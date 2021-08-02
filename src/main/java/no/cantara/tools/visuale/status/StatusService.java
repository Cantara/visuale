package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import no.cantara.tools.visuale.domain.ServiceType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

public class StatusService implements Runnable {

    public static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .findAndRegisterModules();//.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature());

    public static final Logger logger = LoggerFactory.getLogger(StatusService.class);

    public static final AtomicReference<String> DASHBOARD_ENVIRONMENT_NAME_REF = new AtomicReference<>("unknown-environment");

    private final Thread eventConsumerThread;
    private final BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

    private final AtomicReference<String> environmentAsString = new AtomicReference<>();

    private final boolean STRICT_ENVIRONMENT = false;

    private final AtomicBoolean shouldRun = new AtomicBoolean(true);

    // An internal cache used only by the event-consumer-thread, so no synchronization is necessary
    private final Map<String, Node> nodeByLookupKey = new LinkedHashMap<>();

    // Internal environment used only b y the event-consumer-thread
    private Environment environmentCache = new Environment();


    public StatusService() {
        this.eventConsumerThread = new Thread(this, "status-event-consumer");
        this.eventConsumerThread.start();
    }

    public void stopEventLoop() {
        shouldRun.set(false);
        queueInternal(new ControlEventData());
    }

    /**
     * Wait for the events
     *
     * @param timeout
     * @param unit
     */
    public void waitForEvents(long timeout, TimeUnit unit) {
        ControlEventData control = new ControlEventData();
        queueInternal(control);
        control.join(timeout, unit);
    }

    private void queueInternal(Object object) {
        eventQueue.add(new Event(Instant.now(), object));
    }

    public void queue(Health updatedHealth) {
        queueInternal(updatedHealth);
    }

    public void queue(Environment environment) {
        queueInternal(environment);
    }

    public void queue(EnvironmentUpdateHolder environmentUpdateHolder) {
        queueInternal(environmentUpdateHolder);
    }

    public void queueEnvironmentUpdate(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        EnvironmentUpdateHolder environmentUpdateHolder = new EnvironmentUpdateHolder(envName, serviceName, serviceTag, serviceType, nodeName, health);
        queue(environmentUpdateHolder);
    }

    public void queueFullEnvironment(String envJson, String environment_name) {
        Environment environment = new Environment().withName(environment_name);
        try {
            environment = mapper.readValue(envJson, Environment.class);
        } catch (Exception e) {
            logger.error("Unable to initialise dashboard environment", e);
        }
        environment.setName(environment_name);
        queue(environment);
    }

    public String getEnvironmentAsString() {
        return environmentAsString.get();
    }

    private void updateEnvironmentString() throws JsonProcessingException {
        String updatedEnvironmentString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environmentCache);
        if (hasValue(updatedEnvironmentString)) {
            environmentAsString.set(updatedEnvironmentString);
        }
    }

    @Override
    public void run() {
        /*
         * Loops over events, waiting if necessary until an event becomes available. The externally visible environment
         * json string will only be serialized on every X events when there is a backlog in the queue. Once the queue is
         * empty the environment string is always updated immediately.
         */
        final int X = 25;
        while (shouldRun.get()) {
            try {
                Event event = eventQueue.poll(2, TimeUnit.SECONDS);
                boolean environmentNeedsUpdate = false;
                for (int i = 1; event != null && shouldRun.get(); i++) {
                    environmentNeedsUpdate |= processEventInternal(event);
                    if (environmentNeedsUpdate && (i % X == 0)) {
                        updateEnvironmentString();
                        environmentNeedsUpdate = false;
                    }
                    event = eventQueue.poll();
                }

                if (environmentNeedsUpdate) {
                    updateEnvironmentString();
                }

            } catch (Throwable t) {
                logger.error("", t);
            }
        }
        logger.info("Event-loop stopped");
    }

    private boolean processEventInternal(Event event) {
        boolean environmentUpdated = false;
        try {
            switch (event.getEventType()) {
                case CONTROL:
                    // rare event, typically used for debugging and testing
                    updateEnvironmentString(); // Update environment-string visible BEFORE signalling the control object
                    ControlEventData control = event.control();
                    control.signal();
                    break;
                case ENVIRONMENT:
                    Environment environment = event.environment();
                    environmentCache = environment;
                    refreshNodeCache(environment);
                    environmentUpdated = true;
                    break;
                case ENVIRONMENT_UPDATE_HOLDER:
                    EnvironmentUpdateHolder environmentUpdateHolder = event.environmentUpdateHolder();
                    updateEnvironmentExecution(
                            environmentUpdateHolder.envName,
                            environmentUpdateHolder.serviceName,
                            environmentUpdateHolder.serviceTag,
                            environmentUpdateHolder.serviceType,
                            environmentUpdateHolder.nodeName,
                            environmentUpdateHolder.health);
                    environmentUpdated = true;
                    break;
                case HEALTH:
                    Health health = event.health();
                    processHealth(health);
                    environmentUpdated = true;
                    break;
                case SERVICE:
                case NODE:
                    logger.warn("Received unsupported event: " + event.getEventType().name());
                    break;
            }

        } catch (Exception e) {
            logger.error("Unable to update environmentAsString:", e);
        }

        return environmentUpdated;
    }

    private void refreshNodeCache(Environment environment) {
        nodeByLookupKey.clear();
        for (Service service : environment.getServices()) {
            for (Node node : service.getNodes()) {
                if (node.getName() == null || node.getName().length() < 2) {
                    node.setName(service.getName());
                }
                nodeByLookupKey.put(node.getLookupKey(), node);
            }
            if (service.getServiceType() == null) {
                service.setServiceType(ServiceType.ServiceCategorization.CS.name());
            }
        }
    }

    private void processHealth(Health updatedHealth) {
        logger.trace("Received health update: {}", updatedHealth);
        try {
            Node node = nodeByLookupKey.get(updatedHealth.getLookupKey());
            if (node == null) {
                logger.debug("Added new service from health update: {}", updatedHealth);
                String name = updatedHealth.getName();
                if (name == null || name.length() < 2) {
                    name = "Unknown - " + UUID.randomUUID();
                }
                node = new Node().withName(name).withIp(updatedHealth.getIp()).withVersion(updatedHealth.getVersion()).withHealth(updatedHealth);

                no.cantara.tools.visuale.domain.Service s =
                        new no.cantara.tools.visuale.domain.Service().withNode(node).withName(name);
                environmentCache.addService(s);
                nodeByLookupKey.put(node.getLookupKey(), node);
            } else {
                //logger.trace("Updated service from health update: {}", updatedHealth);
                node.addHealth(updatedHealth);
                if (hasValue(updatedHealth.getIp())) {
                    node.setIp(updatedHealth.getIp());
                }
            }
        } catch (Exception e) {
            logger.error("Received un-mappable health.", e);
        }
    }

    private boolean updateEnvironmentExecution(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        boolean foundNode = false;
        boolean foundService = false;
        boolean foundEnvironment = false;

        if (!STRICT_ENVIRONMENT || environmentCache.getName().equalsIgnoreCase(envName)) {
            foundEnvironment = true;
            Set<Service> serviceSet = environmentCache.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (service.getName().equalsIgnoreCase(serviceName)) {  // We found a candidate
                    // TODO revisit this  foundService = true;
                    if (hasValue(serviceTag) // we have a tag
                            && service.getServiceTag() != null  // we do not want any NPEs
                            && !service.getServiceTag().equalsIgnoreCase(serviceTag)) {  // And we need a service object for each tag
                        //  We have a tag and it is different, thus skip parsing nodes
                        if (hasValue(serviceType)) {
                            service.setServiceType(serviceType);
                            // TODO return true missing here?
                        }
                    } else {
                        Set<Node> nodeSet = service.getNodes();
                        foundService = true;
                        if (hasValue(serviceType)) {
                            service.setServiceType(serviceType);
                        }
                        for (Node node : nodeSet) {
                            if (node.getName().equalsIgnoreCase(nodeName)) {
                                Health latest = node.getLatestHealth();
                                Health earliest = node.getEarliestHealth();
                                if (hasValue(health.getIp()) && hasValue(node.getIp()) && !health.getIp().equalsIgnoreCase(node.getIp())) {
                                    Node addnode = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                                    if (hasValue(health.getIp())) {
                                        addnode.setIp(health.getIp());
                                    }
                                    if (hasValue(health.getVersion())) {
                                        addnode.setVersion(health.getVersion());
                                    }
                                    service.addNode(addnode);
                                    nodeByLookupKey.put(addnode.getLookupKey(), addnode);
                                    return true;
                                } else if (latest == null) {
                                    Node addnode = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                                    if (hasValue(health.getIp())) {
                                        addnode.setIp(health.getIp());
                                    }
                                    if (hasValue(health.getVersion())) {
                                        addnode.setVersion(health.getVersion());
                                    }
                                    service.addNode(addnode);
                                    nodeByLookupKey.put(addnode.getLookupKey(), addnode);
                                    return true;
                                } else if (latest.getRunningSince().equalsIgnoreCase(health.getRunningSince())) {
                                    node.addHealth(health);
                                    return true;
                                }
//                              if (hasValue(node.getH.getIp()) && hasValue(node.getIp()) && !health.getIp().equalsIgnoreCase(node.getIp())) {
//                          if (hasValue(health.getIp()) && hasValue(node.getIp()) && !health.getIp().equalsIgnoreCase(node.getIp())) {

                                foundNode = true;
//                                OffsetDateTime date = OffsetDateTime.parse(health.getNow());
//                                if (date.isAfter(OffsetDateTime.from(Instant.now().minus(3, ChronoUnit.MINUTES)))) {
//                                    health.setRunningSince(earliest.getRunningSince());
//                                }

                                node.addHealth(health);
                                if (hasValue(health.getIp())) {
                                    node.setIp(health.getIp());
                                }
                                if (hasValue(health.getVersion())) {
                                    node.setVersion(health.getVersion());
                                }
                                if (hasValue(serviceType)) {
                                    service.setServiceType(serviceType);
                                }

                                return true;
                            }
                        }
                    }
                }
            }
            if (!foundService) {
                Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());

                no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service()
                        .withName(serviceName).withServiceTag(serviceTag).withServiceType(serviceType)
                        .withNode(node);
                environmentCache.addService(service);
                nodeByLookupKey.put(node.getLookupKey(), node);
                return true;
            }
            if (!foundNode) {
                for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                    if (service.getName().equalsIgnoreCase(serviceName)) {
                        if (service.getServiceTag() != null  // we do not want any NPEs
                                && service.getServiceTag().equalsIgnoreCase(serviceTag)) {
                            Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                            service.addNode(node);
                            nodeByLookupKey.put(node.getLookupKey(), node);
                            if (hasValue(serviceType)) {
                                service.setServiceType(serviceType);
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return foundEnvironment;
    }
}

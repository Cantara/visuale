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
import no.cantara.tools.visuale.notifications.NotificationService;
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

    private final Thread eventConsumerThread;
    private final BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

    private final AtomicReference<String> environmentAsString = new AtomicReference<>();

    private final boolean STRICT_ENVIRONMENT = false;

    private final AtomicBoolean shouldRun = new AtomicBoolean(true);

    // An internal cache used only by the event-consumer-thread, so no synchronization is necessary
    private final Map<String, Node> nodeByLookupKey = new LinkedHashMap<>();

    // Internal environment used only b y the event-consumer-thread
    private Environment environmentCache = new Environment();

    private final AtomicReference<String> environmentNameRef = new AtomicReference<>("unknown-environment");

    private final NotificationService notificationService;

    public StatusService() {
        this.eventConsumerThread = new Thread(this, "status-event-consumer");
        this.eventConsumerThread.start();
        this.notificationService = new NotificationService(environmentNameRef::get);
    }

    public void shutdown() {
        shouldRun.set(false);
        queueInternal(new ControlEventData());
        notificationService.getNotificationClient().shutdown();
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

    private void publishEnvironmentChanges() throws JsonProcessingException {
        String updatedEnvironmentString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environmentCache);
        if (hasValue(updatedEnvironmentString)) {
            environmentAsString.set(updatedEnvironmentString);
        }

        sendNotifications();
    }

    private void sendNotifications() {
        for (Service service : environmentCache.getServices()) {
            int healthy_nodes = service.getHealthyNodes();
            if (healthy_nodes < 1) {
                notificationService.sendAlarm(service.getName(), "Alarm - No healthy service nodes");
            } else if (healthy_nodes < 2) {
                notificationService.sendWarning(service.getName(), "Warning - Less than two healthy service nodes, healthy nodes now: [" + healthy_nodes + "]");
            } else {
                notificationService.clearService(service.getName());
            }
        }
    }

    @Override
    public void run() {
        /*
         * Loops over events, waiting if necessary until an event becomes available. The externally visible environment
         * json string will only be serialized on every X events when there is a backlog in the queue. Once the queue is
         * empty the environment changes are always published immediately.
         */
        final int X = 25;
        while (shouldRun.get()) {
            try {
                Event event = eventQueue.poll(2, TimeUnit.SECONDS);
                boolean environmentHasChanged = false;
                for (int i = 1; event != null && shouldRun.get(); i++) {
                    environmentHasChanged |= processEventInternal(event);
                    if (environmentHasChanged && (i % X == 0)) {
                        publishEnvironmentChanges();
                        environmentHasChanged = false;
                    }
                    event = eventQueue.poll();
                }

                if (environmentHasChanged) {
                    publishEnvironmentChanges();
                }

            } catch (Throwable t) {
                logger.error("", t);
            }
        }
        logger.info("Status event-loop stopped");
    }

    private boolean processEventInternal(Event event) {
        boolean environmentUpdated = false;
        try {
            switch (event.getEventType()) {
                case CONTROL:
                    // rare event, typically used for debugging and testing
                    publishEnvironmentChanges(); // publish changes BEFORE signalling the control object
                    ControlEventData control = event.control();
                    control.signal();
                    break;
                case ENVIRONMENT:
                    Environment environment = event.environment();
                    environmentCache = environment;
                    environmentNameRef.set(environment.getName());
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

    private String getNodeLookupKey(Service service, Node node) {
        String key = (service.getServiceTag() != null ? service.getServiceTag().toLowerCase() : "")
                + ":" + service.getName().toLowerCase()
                + ":" + node.getName()
                + ":" + node.getIp();
        return key;
    }

    private void refreshNodeCache(Environment environment) {
        nodeByLookupKey.clear();
        for (Service service : environment.getServices()) {
            for (Node node : service.getNodes()) {
                if (node.getName() == null || node.getName().length() < 2) {
                    node.setName(service.getName());
                }
                nodeByLookupKey.put(getNodeLookupKey(service, node), node);
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
                nodeByLookupKey.put(getNodeLookupKey(s, node), node);
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
        if (!STRICT_ENVIRONMENT || environmentCache.getName().equalsIgnoreCase(envName)) {
            // environment found
            Set<Service> serviceSet = environmentCache.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (serviceMatches(serviceName, serviceTag, service)) {
                    // service found
                    if (hasValue(serviceType)) {
                        service.setServiceType(serviceType);
                    }
                    for (Node node : service.getNodes()) {
                        if (node.getName().equalsIgnoreCase(nodeName)
                                && hasValue(health.getIp()) && hasValue(node.getIp()) && health.getIp().equalsIgnoreCase(node.getIp())) {
                            // node matches name and ip
                            node.addHealth(health);
                            return true;
                        }
                    }
                    // node name or ip does not match
                    for (Node node : service.getNodes()) {
                        if (node.getName().equalsIgnoreCase(nodeName)) {
                            // node matches name, so ip must be different
                            if (hasValue(node.getIp()) && node.getIp().equals("0.0.0.0")) {
                                // existing node has ip 0.0.0.0, update ip and use node
                                node.setIp(health.getIp());
                                node.addHealth(health);
                                return true;
                            }
                            if (hasValue(health.getIp()) && health.getIp().equals("0.0.0.0")) {
                                // incoming node has ip 0.0.0.0, so use this first found node with name match
                                node.setIp(health.getIp()); // update node ip
                                node.addHealth(health);
                                return true;
                            }
                        }
                    }

                    // Service matches, but node not found. Create and add node to service
                    Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                    addNodeToService(service, node);
                    return true;
                }
            }

            // Service not found
            no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service()
                    .withName(serviceName).withServiceTag(serviceTag).withServiceType(serviceType);
            environmentCache.addService(service);
            Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
            addNodeToService(service, node);

            return true;
        }

        return false; // no update performed
    }

    /*
     * true if the given serviceName and serviceTag matches that of the given service.
     */
    private boolean serviceMatches(String serviceName, String serviceTag, Service service) {
        if (!service.getName().equalsIgnoreCase(serviceName)) {
            return false; // service-name is different
        }
        if (service.getServiceTag() == null) {
            return serviceTag == null;
        }
        return service.getServiceTag().equalsIgnoreCase(serviceTag);
    }

    private void addNodeToService(Service service, Node node) {
        boolean nodeAddedToService = service.addNode(node);
        if (nodeAddedToService) {
            nodeByLookupKey.put(getNodeLookupKey(service, node), node);
        }
    }

}

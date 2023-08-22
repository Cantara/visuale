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
import no.cantara.tools.visuale.notifications.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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

    public static final Logger log = LoggerFactory.getLogger(StatusService.class);

    private final Thread eventConsumerThread;
    private final BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>();

    private final AtomicReference<String> environmentAsString = new AtomicReference<>();

    private final boolean STRICT_ENVIRONMENT = false;

    private final AtomicBoolean shouldRun = new AtomicBoolean(true);

    // Internal environment used only b y the event-consumer-thread
    private Environment environmentCache = new Environment();

    private final AtomicReference<String> environmentNameRef = new AtomicReference<>("unknown-environment");

    private final NotificationService notificationService;

    public StatusService() {
        this.eventConsumerThread = new Thread(this, "status-event-consumer");
        this.eventConsumerThread.start();
        this.notificationService = new NotificationService(environmentNameRef::get);
    }

    public String getEnvironmentName() {
        return environmentNameRef.get();
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
        if (object != null) {
            eventQueue.add(new Event(Instant.now(), object));
        }
    }

    public void queue(Environment environment) {
        queueInternal(environment);
    }

    public void queue(NodeHealthData environmentUpdateHolder) {
        queueInternal(environmentUpdateHolder);
    }

    public void queueNodeHealth(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        NodeHealthData environmentUpdateHolder = new NodeHealthData(envName, serviceName, serviceTag, serviceType, nodeName, health);
        queue(environmentUpdateHolder);
    }

    public void queueFullEnvironment(String envJson, String environment_name) {
        Environment environment = new Environment().withName(environment_name);
        try {
            environment = mapper.readValue(envJson, Environment.class);
        } catch (Exception e) {
            log.error("Unable to initialise dashboard environment", e);
        }
        environment.setName(environment_name);
        queue(environment);
    }

    public String getEnvironmentAsString() {
        return environmentAsString.get();
    }

    private void publishEnvironmentChanges() throws JsonProcessingException {
        // take note of time before sending message for more accurate throttling
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
                log.error("", t);
            }
        }
        log.info("Status event-loop stopped");
    }

    final int MIN_INTERVAL_BETWEEN_SENDS_MS = 1000;
    long lastSent = 0;
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
                    environmentUpdated = true;
                    break;
                case NODE:
                    NodeHealthData environmentUpdateHolder = event.environmentUpdateHolder();
                    updateNode(
                            environmentUpdateHolder.envName,
                            environmentUpdateHolder.serviceName,
                            environmentUpdateHolder.serviceTag,
                            environmentUpdateHolder.serviceType,
                            environmentUpdateHolder.nodeName,
                            environmentUpdateHolder.health);
                    environmentUpdated = true;
                    break;
            }

        } catch (Exception e) {
            log.error("Unable to update environmentAsString:", e);
        }

        long now = System.currentTimeMillis();
        long millisSinceLastSent = Math.max(0, now - lastSent); // avoid negative duration due to clock sync
        if (millisSinceLastSent < MIN_INTERVAL_BETWEEN_SENDS_MS) {
            return false;
        }
        lastSent = System.currentTimeMillis();
        return environmentUpdated;
    }

    private boolean updateNode(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        if (!STRICT_ENVIRONMENT || environmentCache.getName().equalsIgnoreCase(envName)) {
            // environment found
            Set<Service> serviceSet = environmentCache.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (serviceMatches(serviceName, serviceTag, service)) {
                    // service found

                    if (hasValue(serviceType)) {
                        service.setServiceType(serviceType);
                    }


                    List<Node> nodesWithMatchingName = new ArrayList<>(1);
                    for (Node node : service.getNodes()) {
                        if (node.getName().equalsIgnoreCase(nodeName)) {
                            nodesWithMatchingName.add(node);
                        }
                    }

                    if (nodesWithMatchingName.size() > 0) {
                        // at least one node match on name
                        try {

                            for (Node node : nodesWithMatchingName) {
                                if (hasValue(health.getIp()) && hasValue(node.getIp()) && health.getIp().equalsIgnoreCase(node.getIp())) {
                                    // node matches name and ip
                                    if (health != null && node != null && node.getVersion() != null && health.getVersion() != null
                                            && !node.getVersion().equalsIgnoreCase(health.getVersion())) {
                                        notificationService.sendInfo(service.getName() + " - " + node.getName(), String.format("New release [%s] detected", health.getVersion()));
                                        node.setVersion(health.getVersion());
                                        notificationService.clearService(service.getName());
                                    }
                                    node.addHealth(health);
                                    return true;
                                }
                            }

                            // no nodes match on ip

                            for (Node node : nodesWithMatchingName) {
                                if (!hasValue(node.getIp()) || node.getIp().equals("0.0.0.0") || node.getIp().equals("10.10.10.10")) {
                                    // existing node has ip empty or 0.0.0.0, update ip and use node
                                    node.setIp(health.getIp());
                                    node.addHealth(health);
                                    return true;
                                }
                            }

                            if (!hasValue(health.getIp()) || health.getIp().equals("0.0.0.0") || health.getIp().equals("10.10.10.10")) {
                                // incoming node has ip empty or 0.0.0.0, so use this first found node with name match
                                for (Node node : nodesWithMatchingName) {
                                    node.setIp(health.getIp());
                                    node.addHealth(health);
                                    return true;
                                }
                            }

                            // Node-name conflict detected, there exists a node within service that match on node-name but ip-address is different.
                            // We will allow this to cause another node with same name to be created, but log a warning in Visuale.
                            Node conflictingNode = nodesWithMatchingName.get(0);
                            log.warn("Conflicting node-name in Service '{}:{}'. Node '{}:{}' conflicts with node '{}:{}'",
                                    service.getServiceTag(), service.getName(), nodeName, health.getIp(),
                                    conflictingNode.getName(), conflictingNode.getIp());
                        } catch (Exception e) {
                            log.error("Unable to process new health.", e);
                        }
                    }

                    // Service matches, but no matching node found. Create node and add to service
                    Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                    service.addNode(node);
                    return true;
                }
            }

            // Service not found
            no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service()
                    .withName(serviceName).withServiceTag(serviceTag).withServiceType(serviceType);
            Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
            service.addNode(node);
            notifyWhenNewServiceIsFound(service);
            environmentCache.addService(service);

            return true;
        }

        return false; // no update performed
    }

    private void notifyWhenNewServiceIsFound(Service service) {
        if(environmentCache.getServices().stream().noneMatch(s -> s.getName().equals(service.getName()))){
            notificationService.sendInfo(service.getName(), String.format("New service [%s] detected", service.getName()));
        }
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
}

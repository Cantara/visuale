package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import no.cantara.tools.visuale.HealthResource;
import no.cantara.tools.visuale.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

public class StatusService {

    public static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .findAndRegisterModules();//.enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature());

    public static final Logger logger = LoggerFactory.getLogger(StatusService.class);

    private static int envCount = 0;

    private Map<String, Node> healthResultsQueue = new ConcurrentHashMap<>();
    private Map<String, EnvironmentUpdateHolder> environmentUpdateQueue = new ConcurrentHashMap<>();
    private Set<Health> healthQueue = new CopyOnWriteArraySet<>();
    private Environment environment = new Environment();

    public static String DASHBOARD_ENVIRONMENT_NAME = HealthResource.applicationInstanceName;

    private String environmentAsString;

    private final boolean STRICT_ENVIRONMENT = false;
    ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(1);


    public StatusService() {
        updateEnvironmentAsStringExecution();
        startSyncThread();
    }

    public void initializeEnvironment(Environment initenv) {
        this.environment = initenv;
        DASHBOARD_ENVIRONMENT_NAME = environment.getName();
        updateEnvironmentAsStringExecution();
    }

    public void initializeEnvironment(String envJson, String environment_name) {
        environment = new Environment().withName(environment_name);
        DASHBOARD_ENVIRONMENT_NAME = environment.getName();
        try {
            environment = mapper.readValue(envJson, Environment.class);
            for (no.cantara.tools.visuale.domain.Service service : environment.getServices()) {
                for (Node node : service.getNodes()) {
                    if (node.getName() == null || node.getName().length() < 2) {
                        node.setName(service.getName());
                    }
                    healthResultsQueue.put(node.getLookupKey(), node);
                }
                if (service.getServiceType() == null) {
                    service.setServiceType(ServiceType.ServiceCategorization.CS.name());
                }
            }
        } catch (Exception e) {
            logger.error("Unable to initialise dashboard environment", e);
        }
        environment.setName(environment_name);
        updateEnvironmentAsStringExecution();
    }

    public int updateHealthMap(Health updatedHealth) {
        if (updatedHealth.isEmpty()) {
            return healthResultsQueue.size();
        }
        logger.trace("Received health update: {}", updatedHealth);
        healthQueue.add(updatedHealth);
        if (healthQueue.size() > 5) {
            updateEnvironmentAsStringExecution();
        }
        return healthResultsQueue.size();
    }

    private synchronized void processEnvironmentQueue() {
        for (String updatedEnvironmentTimestamp : environmentUpdateQueue.keySet()) {
            EnvironmentUpdateHolder environmentUpdateHolder = environmentUpdateQueue.remove(updatedEnvironmentTimestamp);
            if (environmentUpdateHolder != null) {
                updateEnvironmentExecution(
                        environmentUpdateHolder.envName,
                        environmentUpdateHolder.serviceName,
                        environmentUpdateHolder.serviceTag,
                        environmentUpdateHolder.serviceType,
                        environmentUpdateHolder.nodeName,
                        environmentUpdateHolder.health);
            }
        }
    }

    private synchronized void processHealthQueue() {
        for (Health updatedHealth : healthQueue) {
            healthQueue.remove(updatedHealth);
            //logger.trace("Received health update: {}", updatedHealth);
            try {
                Node node = healthResultsQueue.get(updatedHealth.getLookupKey());
                if (node == null) {
                    logger.debug("Added new service from health update: {}", updatedHealth);
                    String name = updatedHealth.getName();
                    if (name == null || name.length() < 2) {
                        name = "Unknown - " + UUID.randomUUID().toString();
                    }
                    node = new Node().withName(name).withIp(updatedHealth.getIp()).withVersion(updatedHealth.getVersion()).withHealth(updatedHealth);

                    no.cantara.tools.visuale.domain.Service s =
                            new no.cantara.tools.visuale.domain.Service().withNode(node).withName(name);
                    environment.addService(s);
                    healthResultsQueue.put(node.getLookupKey(), node);
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
    }

    public boolean updateEnvironment(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        EnvironmentUpdateHolder environmentUpdateHolder = new EnvironmentUpdateHolder(envName, serviceName, serviceTag, serviceType, nodeName, health);
        environmentUpdateQueue.put(Instant.now().toString(), environmentUpdateHolder);
        return true;
    }

    private synchronized boolean updateEnvironmentExecution(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        boolean foundNode = false;
        boolean foundService = false;
        boolean foundEnvironment = false;

        if (!STRICT_ENVIRONMENT || environment.getName().equalsIgnoreCase(envName)) {
            foundEnvironment = true;
            Set<Service> serviceSet = environment.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (service.getName().equalsIgnoreCase(serviceName)) {  // We found a candidate
                    // TODO revisit this  foundService = true;
                    if (hasValue(serviceTag) // we have a tag
                            && service.getServiceTag() != null  // we do not want any NPEs
                            && !service.getServiceTag().equalsIgnoreCase(serviceTag)) {  // And we need a service object for each tag
                        //  We have a tag and it is different, thus skip parsing nodes
                        if (hasValue(serviceType)) {
                            service.setServiceType(serviceType);
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
                                    updateEnvironmentAsStringQueue();
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
                                    updateEnvironmentAsStringQueue();
                                    return true;
                                } else if (latest.getRunningSince().equalsIgnoreCase(health.getRunningSince())) {
                                    node.addHealth(health);
                                    updateEnvironmentAsStringQueue();
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

                                updateEnvironmentAsStringQueue();
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
                environment.addService(service);
                updateEnvironmentAsStringQueue();
                return true;
            }
            if (!foundNode) {
                for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                    if (service.getName().equalsIgnoreCase(serviceName)) {
                        if (service.getServiceTag() != null  // we do not want any NPEs
                                && service.getServiceTag().equalsIgnoreCase(serviceTag)) {
                            Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                            service.addNode(node);
                            if (hasValue(serviceType)) {
                                service.setServiceType(serviceType);
                            }
                            updateEnvironmentAsStringQueue();
                            return true;
                        }
                    }
                }
            }
            //   CompletionStage<String> jsonObject = request.content().as(String.class).thenApply(this::updateHealthMap2);
        }
        return foundEnvironment;
    }


    public Map<String, Node> getHealthStatusMap() {
        return healthResultsQueue;
    }

    public int getHealthStatusMapSize() {
        return healthResultsQueue.size();
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    private synchronized void updateEnvironmentAsStringQueue() {
        updateEnvironmentAsStringExecution();
        if (envCount < 10) {
            envCount++;
        } else {
            envCount = 0;

        }
    }

    private synchronized void updateEnvironmentAsStringExecution() {
        String updatedEnvironmentString = null;
        try {
            processHealthQueue();
            processEnvironmentQueue();
            updatedEnvironmentString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
        } catch (Exception e) {
            logger.error("Unable to update environmentAsString:", e);
        }
        if (hasValue(updatedEnvironmentString)) {
            environmentAsString = updatedEnvironmentString;
        }
    }

    public String getEnvironmentAsString() {
        return environmentAsString;
    }

    private void startSyncThread() {
        Runnable task2 = () -> {
            updateEnvironmentAsStringExecution();
        };
        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture2 = ses2.scheduleAtFixedRate(task2, 3, 1, TimeUnit.SECONDS);
    }
}

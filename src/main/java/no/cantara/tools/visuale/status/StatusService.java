package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.*;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;
import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

public class StatusService {

    public static ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

    public static final Logger logger = LoggerFactory.getLogger(StatusService.class);

    private Map<String, Node> healthResults = new HashMap<>();
    private Set<Health> healthQueue = new CopyOnWriteArraySet<>();

    private Environment environment = new Environment();

    private String environmentAsString;

    private final boolean STRICT_EMVIRONMANT = false;
    ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(1);


    public StatusService() {
        updateEnvironmentAsString();
        startSyncThread();
    }

    public StatusService(String environmentJson, String environmentName) {
        environment = null;
        initializeEnvironment(MOCK_ENVORONMENT, "Visuale DEVTEST");
        updateEnvironmentAsString();
        startSyncThread();
    }


    public int updateHealthMap(Health updatedHealth) {
        if (updatedHealth.isEmpty()) {
            return healthResults.size();
        }
        logger.trace("Received health update: {}", updatedHealth);
        healthQueue.add(updatedHealth);
        if (healthQueue.size() > 5) {
            updateEnvironmentAsString();
        }
        return healthResults.size();
    }

    private synchronized void processHealthQueue() {
        for (Health updatedHealth : healthQueue) {
            healthQueue.remove(updatedHealth);
            //logger.trace("Received health update: {}", updatedHealth);
            try {
                Node node = healthResults.get(updatedHealth.getLookupKey());
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
                    healthResults.put(node.getLookupKey(), node);
                } else {
                    //logger.trace("Updated service from health update: {}", updatedHealth);
                    node.addHealth(updatedHealth);
                    if (hasValue(updatedHealth.getIp())) {
                        node.setIp(updatedHealth.getIp());
                    }
                }
            } catch (Exception e) {
                logger.error("Received unmappable health", e);
            }
        }
    }

    public boolean updateEnvironment(String envName, String serviceName, String serviceTag, String serviveType, String nodeName, Health health) {
        boolean foundNode = false;
        boolean foundService = false;
        boolean foundEnvironment = false;

        if (!STRICT_EMVIRONMANT || environment.getName().equalsIgnoreCase(envName)) {
            foundEnvironment = true;
            Set<Service> serviceSet = environment.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (service.getName().equalsIgnoreCase(serviceName)) {  // We found a candidate
                    if (hasValue(serviceTag) // we have a tag
                            && service.getServiceTag() != null  // we do not want any NPEs
                            && !service.getServiceTag().equalsIgnoreCase(serviceTag)) {  // And we need a service object for each tag
                        break;  //  We have a tag and it is different, thus skip parsing nodes
                    }
                    Set<Node> nodeSet = service.getNodes();
                    foundService = true;
                    for (Node node : nodeSet) {
                        if (node.getName().equalsIgnoreCase(nodeName)) {
                            Health latest = node.getLatestHealth();
                            if (latest == null) {
                                Node addnode = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                                if (hasValue(health.getIp())) {
                                    addnode.setIp(health.getIp());
                                }
                                if (hasValue(health.getVersion())) {
                                    addnode.setVersion(health.getVersion());
                                }
                                service.addNode(addnode);
                                updateEnvironmentAsString();
                                return true;
                            } else if (latest.getRunningSince().equalsIgnoreCase(health.getRunningSince())) {
                                node.addHealth(health);
                                updateEnvironmentAsString();
                                return true;
                            }
//                              if (hasValue(node.getH.getIp()) && hasValue(node.getIp()) && !health.getIp().equalsIgnoreCase(node.getIp())) {
//                          if (hasValue(health.getIp()) && hasValue(node.getIp()) && !health.getIp().equalsIgnoreCase(node.getIp())) {

                            foundNode = true;
                            node.addHealth(health);
                            if (hasValue(health.getIp())) {
                                node.setIp(health.getIp());
                            }
                            if (hasValue(health.getVersion())) {
                                node.setVersion(health.getVersion());
                            }
                            updateEnvironmentAsString();
                            return true;
                        }
                    }


                }
            }
            if (!foundService) {
                Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());

                no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service()
                        .withName(serviceName).withServiceTag(serviceTag).withServiceType(serviveType)
                        .withNode(node);
                service.setServiceTag(serviceTag);
                service.setServiceType(serviveType);
                environment.addService(service);
                updateEnvironmentAsString();
                return true;
            }
            if (!foundNode) {
                for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                    if (service.getName().equalsIgnoreCase(serviceName)) {
                        if (service.getServiceTag() != null  // we do not want any NPEs
                                && service.getServiceTag().equalsIgnoreCase(serviceTag)) {
                            Node node = new Node().withName(nodeName).withHealth(health).withIp(health.getIp()).withVersion(health.getVersion());
                            service.addNode(node);
                            updateEnvironmentAsString();
                            return true;
                        }
                    }
                }
            }
            //   CompletionStage<String> jsonObject = request.content().as(String.class).thenApply(this::updateHealthMap2);
        }
        return foundEnvironment;
    }

    public void initializeEnvironment(Environment initenv) {
        this.environment = initenv;
    }

    public void initializeEnvironment(String envJson, String environment_name) {
        environment = new Environment().withName(environment_name);
        try {
            environment = mapper.readValue(envJson, Environment.class);
            for (no.cantara.tools.visuale.domain.Service service : environment.getServices()) {
                for (Node node : service.getNodes()) {
                    if (node.getName() == null || node.getName().length() < 2) {
                        node.setName(service.getName());
                    }
                    healthResults.put(node.getLookupKey(), node);
                }
            }
        } catch (Exception e) {
            logger.error("Unable to initialise dashboard environment", e);
        }
        environment.setName(environment_name);
    }

    public Map<String, Node> getHealthStatusMap() {
        return healthResults;
    }

    public int getHealthStatusMapSize() {
        return healthResults.size();
    }

    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    public Environment getEnvironment() {
        return environment;
    }

    private synchronized void updateEnvironmentAsString() {
        try {
            processHealthQueue();
            environmentAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
        } catch (Exception e) {
            logger.error("Unable to uodate environmentAsString", e);
        }
    }

    public String getEnvironmentAsString() {
        return environmentAsString;
    }

    private void startSyncThread() {
        Runnable task2 = () -> {
            updateEnvironmentAsString();
        };
        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture2 = ses2.scheduleAtFixedRate(task2, 3, 1, TimeUnit.SECONDS);
    }
}

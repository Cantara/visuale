package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonBuilderFactory;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

public class StatusService {

    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

    public static final Logger logger = LoggerFactory.getLogger(StatusService.class);

    private Map<String, Node> healthResults = new HashMap<>();

    private Environment environment = new Environment();
    ;
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


    public synchronized int updateHealthMap(Health updatedHealth) {
        logger.debug("Received health update: {}", updatedHealth);
        try {
            Node node = healthResults.get(updatedHealth.getLookupKey());
            if (node == null) {
                logger.debug("Added new service from health update: {}", updatedHealth);
                String name = updatedHealth.getName();
                if (name == null || name.length() < 2) {
                    name = "Unknown - " + UUID.randomUUID().toString();
                }
                node = new Node().withName(name).withIp(updatedHealth.getIp()).withHealth(updatedHealth);

                no.cantara.tools.visuale.domain.Service s =
                        new no.cantara.tools.visuale.domain.Service().withNode(node).withName(name);
                environment.addService(s);
                healthResults.put(node.getLookupKey(), node);
            } else {
                logger.debug("Updated service from health update: {}", updatedHealth);
                node.addHealth(updatedHealth);
            }
            return node.getHealth().size();
        } catch (Exception e) {
            logger.error("Received unmappable health", e);
        }
        return 0;
    }

    public boolean updateEnvironment(String envName, String serviceName, String nodeName, Health health) {
        boolean foundNode = false;
        boolean foundService = false;
        boolean foundEnvironment = false;

        if (!STRICT_EMVIRONMANT || environment.getName().equalsIgnoreCase(envName)) {
            foundEnvironment = true;
            Set<Service> serviceSet = environment.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (service.getName().equalsIgnoreCase(serviceName)) {
                    Set<Node> nodeSet = service.getNodes();
                    foundService = true;
                    for (Node node : nodeSet) {
                        if (node.getName().equalsIgnoreCase(nodeName)) {
                            foundNode = true;
                            node.addHealth(health);
                        }
                    }
                }
            }
            if (!foundService) {
                Node node = new Node().withName(nodeName);
                no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service().withName(serviceName).withNode(node);
                environment.addService(service);
                updateEnvironmentAsString();
            } else if (!foundNode) {
                for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                    if (service.getName().equalsIgnoreCase(serviceName)) {
                        Node node = new Node().withName(nodeName);
                        node.addHealth(health);
                        service.withNode(node);
                        updateEnvironmentAsString();
                    }
                }
            }
            //   CompletionStage<String> jsonObject = request.content().as(String.class).thenApply(this::updateHealthMap2);
        }
        return foundEnvironment;
    }


    public void initializeEnvironment(String envJson, String envoronment_name) {
        environment = new Environment().withName(envoronment_name);
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
        environment.setName(envoronment_name);
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

    private void updateEnvironmentAsString() {
        try {
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

package no.cantara.tools.visuale.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.tools.visuale.domain.*;
import no.cantara.tools.visuale.healthchecker.CommandGetHealthJson;
import no.cantara.tools.visuale.utils.config.ConfEnv;
import no.cantara.tools.visuale.utils.config.ConfNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class EnvironmentConfig {

    public static final Logger logger = LoggerFactory.getLogger(EnvironmentConfig.class);
    private static ObjectMapper mapper = new ObjectMapper();
    private static boolean exists = false;
    private String environmentName = "";
    private Environment environment;
    private String environmentAsString;
    private Set<URI> pollingHealthURISet = new CopyOnWriteArraySet();

    public EnvironmentConfig() {

        ConfEnv readEnvironment = readConfig();
        if (readEnvironment != null) {
            try {
                setUpEnvironment(readEnvironment);
            } catch (Exception e) {
                exists = false;
                logger.error("Unable to parse environment", e);
            }
        }
    }

    private void setUpEnvironment(ConfEnv readEnvironment) throws Exception {
        environmentName = readEnvironment.getEnvironmentName();
        environment = new Environment().withName(environmentName);
        for (ConfNode confNode : readEnvironment.getNodes()) {
            Node node = new Node().withName(confNode.getNodeName());
            Service service = new Service().withName(confNode.getServiceName()).withNode(node);
            environment.addService(service);
            try {
                pollingHealthURISet.add(URI.create(confNode.getHealthUrl()));
                Health h = getInitialHealthJson(URI.create(confNode.getHealthUrl()));
                if (h != null) {
                    node.addHealth(h);
                }
            } catch (Exception e) {
                logger.debug("Found illegal URL, skipping {}", confNode.getHealthUrl());
                // Ignore
            }

        }


        environmentAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
        exists = true;

    }

    private Health getInitialHealthJson(URI u) {
        try {
            String json = new CommandGetHealthJson(u).execute();
            if (json != null && !json.toLowerCase().contains("html")) {
                Health health = HealthMapper.fromRealWorldJson(json);
                return health;
            }
        } catch (Exception e) {
            logger.error("==> Unable to parse json from {} - exception ", u, e);
            // We reduce noise on wrong urls by removing them right now
        }
        return null;
    }

    public String getEnvironment() {
        return environmentAsString;
    }

    public String getEnvironmentName() {
        return environmentName;
    }

    public Set<URI> getPollingHealthURISet() {
        return pollingHealthURISet;
    }

    private ConfEnv readConfig() {
        try (InputStream fileStream = new FileInputStream("./environment_config.json")) {
            ConfEnv envConf = mapper.readValue(fileStream, ConfEnv.class);
            return envConf;
        } catch (Exception e) {
            exists = false;
        }
        return null;
    }
}

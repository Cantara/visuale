package no.cantara.tools.visuale.utils;

import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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

import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

public class EnvironmentConfig {

    public static final Logger logger = LoggerFactory.getLogger(EnvironmentConfig.class);
    private static ObjectMapper mapper = new ObjectMapper().configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
            .configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false)
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .enable(JsonReadFeature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER.mappedFeature())
            .findAndRegisterModules();
    private boolean exists = false;
    private ConfEnv confEnv;
    private String environmentName = "";
    private Environment environment;
    private String environmentAsString;
    private final static Set<URI> pollingHealthURISet = new CopyOnWriteArraySet();

    public EnvironmentConfig() {

        if (!exists) {
            ConfEnv readEnvironment = readConfig();
            if (readEnvironment != null) {
                try {
                    setUpEnvironment(readEnvironment);
                    confEnv = readEnvironment;
                    exists = true;
                } catch (Exception e) {
                    exists = false;
                    logger.error("Unable to parse environment", e);
                }
            }
        }
    }

    private void setUpEnvironment(ConfEnv readEnvironment) throws Exception {
        environmentName = readEnvironment.getEnvironmentName();
        environment = new Environment().withName(environmentName);
        for (ConfNode confNode : readEnvironment.getNodes()) {
            Node node = new Node().withName(confNode.getNodeName());
            Service service = new Service().withName(confNode.getServiceName()).withNode(node).withServiceType(confNode.getServiceType()).withServiceTag(confNode.getServiceTag());
            environment.addService(service);
            try {
                pollingHealthURISet.add(URI.create(confNode.getHealthUrl()));
                Health h = getInitialHealthJson(URI.create(confNode.getHealthUrl()));
                if (h != null) {
                    node.addHealth(h);
                    if (hasValue(h.getIp())) {
                        node.setIp(h.getIp());
                    }
                }
            } catch (Exception e) {
                logger.debug("Found illegal URL, skipping {}", confNode.getHealthUrl());
                // Ignore
            }

        }
        environmentAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
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

    public String getEnvironmentAsString() {
        return environmentAsString;
    }

    public Environment getEnvironment() {
        return environment;
    }

    public ConfEnv getConfEnv() {
        return confEnv;
    }

    public Set<Service> getServices() {
        return environment.getServices();
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

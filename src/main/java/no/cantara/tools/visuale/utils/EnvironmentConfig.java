package no.cantara.tools.visuale.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import no.cantara.tools.visuale.utils.config.ConfEnv;
import no.cantara.tools.visuale.utils.config.ConfNode;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URI;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class EnvironmentConfig {

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
            } catch (Exception e) {
                // Ignore
            }

        }


        environmentAsString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
        exists = true;

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

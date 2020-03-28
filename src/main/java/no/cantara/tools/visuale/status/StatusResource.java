package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.webserver.Routing;
import io.helidon.webserver.Service;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

//import no.cantara.tools.visuale.domain.Service;

@Path("/status")
@RequestScoped
public class StatusResource implements Service {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    private static Map<String, Node> healthResults = new HashMap<>();

    private static Environment environment;

    /**
     * Using constructor injection to get a configuration property.
     * By default this gets the value from META-INF/microprofile-config
     */
    @Inject
    public StatusResource() {
        initializeEnvironment(MOCK_ENVORONMENT, "QuadimDemo");
    }

    public static void initializeEnvironment(String envJson, String envoronment_name) {
        environment = new Environment().withName(envoronment_name);
        try {
            environment = mapper.readValue(envJson, Environment.class);
            for (no.cantara.tools.visuale.domain.Service service : environment.getServices()) {
                for (Node node : service.getNodes()) {
                    if (node.getName() == null || node.getName().length() < 2) {
                        node.setName(service.getName());
                    }
                    healthResults.put(node.getIp() + node.getName(), node);
                }
            }
            environment.setName(envoronment_name);
        } catch (Exception e) {
            logger.error("Unable to inizialise dashboard environment", e);
        }
    }

    public static Map<String, Node> getHealthStatusMap() {
        return healthResults;
    }

    public static int getHealthStatusMapSize() {
        return healthResults.size();
    }

    public static Environment getEnvironment() {
        return environment;
    }

    /**
     * Return a wordly greeting message.
     *
     * @return {@link JsonObject}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String showEnvironment() {
        String msg = environment.toString();
        try {
            msg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);

        } catch (Exception e) {
            logger.error("Unable to serialize environment", e);
        }
        return msg;
    }


    /**
     * Set the greeting to use in future messages.
     *
     * @param jsonObject JSON containing the new greeting
     * @return {@link Response}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateHealfInfo(String jsonObject) {
        //if (!jsonObject.containsKey("status")) {
        updateHealthMap(jsonObject.toString());
        //}

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    public static int updateHealthMap(String json) {
        logger.debug("Received health update: {}", json);
        try {
            Health updatedHealth = mapper.readValue(json, Health.class);
            Node node = healthResults.get(updatedHealth.getIp() + updatedHealth.getName());
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
                healthResults.put(node.getIp() + node.getName(), node);
            } else {
                logger.debug("Updated service from health update: {}", updatedHealth);
                node.addHealth(updatedHealth);
            }
        } catch (Exception e) {
            logger.error("Received unmappable json for health", e);
        }
        return 0;
    }

    public static int updateHealthMap(Health updatedHealth) {
        logger.debug("Received health update: {}", updatedHealth);
        try {
            Node node = healthResults.get(updatedHealth.getIp() + updatedHealth.getName());
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
                healthResults.put(node.getIp() + node.getName(), node);
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


    @Override
    public void update(Routing.Rules rules) {

    }

}


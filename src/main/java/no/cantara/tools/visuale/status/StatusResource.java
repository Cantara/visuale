package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.common.http.Http;
import io.helidon.common.reactive.Multi;
import io.helidon.media.jsonp.server.JsonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import no.cantara.tools.visuale.domain.Node;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

@Path("status")
@RequestScoped
public class StatusResource implements Service {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    private static Map<String, Node> healthResults = new HashMap<>();

    private static Environment environment;
    private static final boolean STRICT_EMVIRONMANT = false;

    /**
     * A service registers itself by updating the routine rules.
     *
     * @param rules the routing rules.
     */
    @Override
    public void update(Routing.Rules rules) {
        rules.get("/status", JsonSupport.create(), this::showEnvironment).put("/status", JsonSupport.create(),
                this::updateHealthInfo).put("/status/{env}/{service}/{node}", JsonSupport.create(), this::updateFullHealthInfo);
    }

    /**
     * Using constructor injection to get a configuration property.
     * By default this gets the value from META-INF/microprofile-config
     */
    @Inject
    public StatusResource() {
        initializeEnvironment(MOCK_ENVORONMENT, "QuadimDemo");
    }


    /**
     * Return a wordly greeting message.
     *
     * @return {@link JsonObject}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void showEnvironment(final ServerRequest request, final ServerResponse response) {
        String msg = environment.toString();
        try {
            msg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment);
        } catch (Exception e) {
            logger.error("Unable to serialize environment", e);
        }
        response.status(200).send(msg);
    }


    /**
     * Set the greeting to use in future messages.
     *
     * @return {@link Response}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @PUT
    public void updateHealthInfo(final ServerRequest request, final ServerResponse response) {
        request.content().as(JsonObject.class).thenAccept(jo -> updateHealthInfoFromJson(jo, response));
        StringBuilder sb = new StringBuilder();
        Multi.from(request.content()).subscribe(chunk -> sb.append(chunk).append("-"));
        Health myHealth = HealthMapper.fromRealWorldJson(sb.toString());
        if (myHealth.getIp() == null || myHealth.getIp().length() < 1) {
            myHealth.setIp(request.remoteAddress());
        }
        if (myHealth.getName() == null || myHealth.getName().length() < 1) {
            myHealth.setName(request.remoteAddress());
        }
        updateHealthMap(myHealth);

        response.status(204).send();
    }

    private void updateHealthInfoFromJson(JsonObject jo, ServerResponse response) {
        if (jo != null || jo.toString().length() < 1) {
            Health myHealth = HealthMapper.fromRealWorldJson(jo.toString());
            updateHealthMap(myHealth);
        }
        response.status(Http.Status.NO_CONTENT_204).send();
    }

    /**
     * Set the greeting to use in future messages.
     *
     * @return {@link Response}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @PUT
    public void updateFullHealthInfo(final ServerRequest request, final ServerResponse response) {
        String envName = request.path().param("env");
        String serviceName = request.path().param("service");
        String nodeName = request.path().param("node");
        StringBuilder sb = new StringBuilder();
        Multi.from(request.content()).subscribe(chunk -> sb.append(chunk).append("-"));
        Health myHealth = HealthMapper.fromRealWorldJson(sb.toString());

        boolean foundNode = false;
        boolean foundService = false;
        boolean foundEnvironment = false;

        if (!STRICT_EMVIRONMANT || environment.getName().equalsIgnoreCase(envName)) {
            foundEnvironment = true;
            Set<no.cantara.tools.visuale.domain.Service> serviceSet = environment.getServices();
            for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                if (service.getName().equalsIgnoreCase(serviceName)) {
                    Set<Node> nodeSet = service.getNodes();
                    foundService = true;
                    for (Node node : nodeSet) {
                        if (node.getName().equalsIgnoreCase(nodeName)) {
                            foundNode = true;
                        }
                    }
                }
            }
            if (!foundService) {
                Node node = new Node().withName(nodeName);
                no.cantara.tools.visuale.domain.Service service = new no.cantara.tools.visuale.domain.Service().withName(serviceName).withNode(node);
                environment.addService(service);
            } else if (!foundNode) {
                for (no.cantara.tools.visuale.domain.Service service : serviceSet) {
                    if (service.getName().equalsIgnoreCase(serviceName)) {
                        Node node = new Node().withName(nodeName);
                        service.withNode(node);
                    }
                }
            }
            //   CompletionStage<String> jsonObject = request.content().as(String.class).thenApply(this::updateHealthMap2);
        }
        if (myHealth.getIp() == null || myHealth.getIp().length() < 1) {
            myHealth.setIp(request.remoteAddress());
        }
        if (myHealth.getName() == null || myHealth.getName().length() < 1) {
            myHealth.setName(request.remoteAddress());
        }
        request.content().as(JsonObject.class).thenAccept(jo -> updateHealthInfoFromJson(jo, response));

        response.status(204).send();
    }


    public String updateHealthMap3(String service, String node, String json) {
        updateHealthMap(json);
        return json;
    }

    public String updateHealthMap2(String json) {
        updateHealthMap(json);
        return json;
    }

    public Health updateHealthMapO(Health json) {
        updateHealthMap(json);
        return json;
    }

    public static int updateHealthMap(String json) {
        logger.debug("Received health update: {}", json);
        Health updatedHealth = HealthMapper.fromRealWorldJson(json);
        return updateHealthMap(updatedHealth);
//        try {
//            Health updatedHealth = HealthMapper.fromRealWorldJson(json);
//            Node node = healthResults.get(updatedHealth.getLookupKey());
//            if (node == null) {
//                logger.debug("Added new service from health update: {}", updatedHealth);
//                String name = updatedHealth.getName();
//                if (name == null || name.length() < 2) {
//                    name = "Unknown - " + UUID.randomUUID().toString();
//                }
//                node = new Node().withName(name).withIp(updatedHealth.getIp()).withHealth(updatedHealth);
//
//                no.cantara.tools.visuale.domain.Service s =
//                        new no.cantara.tools.visuale.domain.Service().withNode(node).withName(name);
//                environment.addService(s);
//                healthResults.put(node.getLookupKey(), node);
//            } else {
//                logger.debug("Updated service from health update: {}", updatedHealth);
//                node.addHealth(updatedHealth);
//            }
//        } catch (Exception e) {
//            logger.error("Received unmappable json for health", e);
//        }
//        return 0;
    }

    public static int updateHealthMap(Health updatedHealth) {
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


    public static void initializeEnvironment(String envJson, String envoronment_name) {
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
            environment.setName(envoronment_name);
        } catch (Exception e) {
            logger.error("Unable to initialise dashboard environment", e);
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

}


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

//import no.cantara.tools.visuale.domain.Service;

@Path("/status")
@RequestScoped
public class StatusResource implements Service {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    Map<String, Node> healthResults = new HashMap<>();

    private Environment environment;

    /**
     * Using constructor injection to get a configuration property.
     * By default this gets the value from META-INF/microprofile-config
     */
    @Inject
    public StatusResource() {
        try {
            Environment environment = mapper.readValue(getMockStatus, Environment.class);
            for (no.cantara.tools.visuale.domain.Service service : environment.getServices()) {
                for (Node node : service.getNodes()) {
                    healthResults.put(node.getIp(), node);
                }

            }
        } catch (Exception e) {
            environment = new Environment();
        }

    }

    /**
     * Return a wordly greeting message.
     *
     * @return {@link JsonObject}
     */
    @SuppressWarnings("checkstyle:designforextension")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getStatusMessage() {
        return createResponse("World").toString();
    }


    private JsonObject createResponse(String who) {
        String msg = environment.toString();

        return JSON.createObjectBuilder()
                .add("message", msg)
                .build();
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
    public Response updateHeartbeat(JsonObject jsonObject) {

        if (!jsonObject.containsKey("status")) {
            try {
                Health updatedHealth = mapper.readValue(jsonObject.toString(), Health.class);
                Node node = healthResults.get(updatedHealth.getIp());
                node.addHealth(updatedHealth);
//                healthResults.put(updatedHealth.getIp(), updatedHealth);
            } catch (Exception e) {
                logger.error("Received unmappable json for health");
            }
        }

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public void update(Routing.Rules rules) {

    }

    private String getMockStatus = "{\"name\": \"Quadim-QA\",\n" +
            "    \"services\": [\n" +
            "      {\n" +
            "        \"name\": \"Overlord-Service\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.23\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.24\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.25\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.26\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Service-2\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Service-2\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]}\n";
}


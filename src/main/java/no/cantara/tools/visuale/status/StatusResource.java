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
import java.util.*;

//import no.cantara.tools.visuale.domain.Service;

@Path("/status")
@RequestScoped
public class StatusResource implements Service {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    Map<String, Health> healthResults = new HashMap<>();

    /**
     * Using constructor injection to get a configuration property.
     * By default this gets the value from META-INF/microprofile-config
     */
    @Inject
    public StatusResource() {

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
        String msg = getDummyMessage();

        return JSON.createObjectBuilder()
                .add("message", msg)
                .build();
    }

    private String getDummyMessage() {
        String json = "{}";
        try {
            Health h = new Health();
            Node n = new Node();
            n.setHealthInfo(h);
            if (n.getIpAddresses() != null && healthResults.get(n.getIpAddresses()) != null) {
                n.setHealthInfo(healthResults.get(n.getIpAddresses()));
            }
            Node n2 = new Node();
            n2.setHealthInfo(h);
            if (n2.getIpAddresses() != null && healthResults.get(n2.getIpAddresses()) != null) {
                n2.setHealthInfo(healthResults.get(n2.getIpAddresses()));
            }

            no.cantara.tools.visuale.domain.Service s = new no.cantara.tools.visuale.domain.Service();
            Set<Node> nodeSet = new HashSet<>();
            nodeSet.add(n);
            nodeSet.add(n2);
            s.setNodes(nodeSet);

            Environment e = new Environment();
            Set<no.cantara.tools.visuale.domain.Service> serviceSet = new HashSet<>();
            serviceSet.add(s);
            e.setServices(serviceSet);

            json = mapper.writeValueAsString(e);
        } catch (Exception e) {
            logger.error("Unable to create json status:", e);
        }
        return json;
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
                healthResults.put(updatedHealth.getIp(), updatedHealth);
            } catch (Exception e) {
                logger.error("Received unmappable json for health");
            }
        }

        String newGreeting = jsonObject.getString("greeting");

        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @Override
    public void update(Routing.Rules rules) {

    }
}


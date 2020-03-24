package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Path("/status")
@RequestScoped
public class StatusResource {
    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    public static ObjectMapper mapper = new ObjectMapper();
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);


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
    public JsonObject getDefaultMessage() {
        return createResponse("World");
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
            Node n2 = new Node();
            n.setHealthInfo(h);

            Service s = new Service();
            Set<Node> nodeSet = new HashSet<>();
            nodeSet.add(n);
            nodeSet.add(n2);
            s.setNodes(nodeSet);

            Environment e = new Environment();
            Set<Service> serviceSet = new HashSet<>();
            serviceSet.add(s);
            e.setServices(serviceSet);

            json = mapper.writeValueAsString(e);
        } catch (Exception e) {
            logger.error("Unable to create json status:", e);
        }
        return json;
    }
}


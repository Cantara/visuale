package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.media.jsonp.server.JsonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("status")
@RequestScoped
public class StatusResource implements Service {
    public static final Logger logger = LoggerFactory.getLogger(StatusResource.class);
    public static ObjectMapper mapper = new ObjectMapper().configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
    StatusService statusService;

    /**
     * A service registers itself by updating the routine rules.
     *
     * @param rules the routing rules.
     */
    @Override
    public void update(Routing.Rules rules) {
        rules.get("/status", JsonSupport.create(), this::showEnvironment).options("/status", JsonSupport.create(), this::showEnvironment).put("/status", JsonSupport.create(),
                this::updateHealthInfo).put("/status/{env}/{service}/{node}", JsonSupport.create(), this::updateFullHealthInfo);
    }

    /**
     * Using constructor injection to get a configuration property.
     * By default this gets the value from META-INF/microprofile-config
     */
    @Inject
    public StatusResource() {
        statusService = new StatusService();
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
        String msg = statusService.getEnvironment().toString();
        try {
            msg = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(statusService.getEnvironment());
        } catch (Exception e) {
            logger.error("Unable to serialize environment", e);
        }
        response.headers().add("Content-Type: application/json", "Access-Control-Allow-Origin: *", "Access-Control-Allow-Methods: GET, OPTIONS");
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
        response.headers().add("Access-Control-Allow-Origin: *", "Access-Control-Allow-Methods: PUT, OPTIONS");
        response.status(204).send();
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

        Health h = (Health) request.content().as(JsonObject.class).thenAccept(jo -> getHealthInfoFromJson(jo, response));

        statusService.updateEnvironment(envName, serviceName, nodeName, h);

        request.content().as(JsonObject.class).thenAccept(jo -> updateHealthInfoFromJson(jo, response));
        response.headers().add("Access-Control-Allow-Origin: *", "Access-Control-Allow-Methods: PUT, OPTIONS");
        response.status(204).send();
    }


    private Health updateHealthInfoFromJson(JsonObject jo, ServerResponse response) {
        Health myHealth = null;
        if (jo != null || jo.toString().length() < 1) {
            myHealth = HealthMapper.fromRealWorldJson(jo.toString());
            statusService.updateHealthMap(myHealth);
        }
        return myHealth;
    }

    private Health getHealthInfoFromJson(JsonObject jo, ServerResponse response) {
        Health myHealth = null;
        if (jo != null || jo.toString().length() < 1) {
            myHealth = HealthMapper.fromRealWorldJson(jo.toString());
        }
        return myHealth;
    }

    public StatusService getStatusService() {
        return statusService;
    }
}


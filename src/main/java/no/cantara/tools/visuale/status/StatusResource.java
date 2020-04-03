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
import javax.ws.rs.core.Response;

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
        rules.get("/status", JsonSupport.create(), this::showEnvironment)
                .options("/status", JsonSupport.create(), this::showEnvironmentOptionHeaders)
                .get("/api/status", JsonSupport.create(), this::showEnvironment)
                .options("/api/status", JsonSupport.create(), this::showEnvironmentOptionHeaders)
                .put("/status", JsonSupport.create(), this::updateHealthInfo)
                .put("/api/status", JsonSupport.create(), this::updateHealthInfo)
                .put("/status/{env}/{service}/{node}", JsonSupport.create(), this::updateFullHealthInfo)
                .put("/api/status/{env}/{service}/{node}", JsonSupport.create(), this::updateFullHealthInfo);
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
     * @return {@link JsonObject}
     */
    @SuppressWarnings("checkstyle:designforextension")
    public synchronized void showEnvironment(final ServerRequest request, final ServerResponse response) {
        String msg = statusService.getEnvironmentAsString();
        response.status(200).send(msg);
    }

    /**
     * @return {@link JsonObject}
     */
    @SuppressWarnings("checkstyle:designforextension")
    public synchronized void showEnvironmentOptionHeaders(final ServerRequest request, final ServerResponse response) {
        response.status(200).headers().add("Content-Type: application/json"
                , "Access-Control-Allow-Origin: *"
                , "Access-Control-Allow-Methods: GET, OPTIONS"
                , "Access-Control-Allow-Headers: *"
                , "Access-Control-Allow-Credentials: true");
    }

    /**
     * @return {@link Response}
     */
    @SuppressWarnings("checkstyle:designforextension")
    public void updateHealthInfo(final ServerRequest request, final ServerResponse response) {
        logger.debug("updateHealthInfo");
        request.content().as(JsonObject.class).thenAccept(jo -> updateHealthInfoFromJson(jo))
                .thenAccept(jo -> response.status(204).send());

    }



    /**
     * @return {@link Response}
     */
    @SuppressWarnings("checkstyle:designforextension")
    public void updateFullHealthInfo(final ServerRequest request, final ServerResponse response) {
        logger.debug("updateFullHealthInfo");
        String envName = request.path().param("env");
        String serviceName = request.path().param("service");
        String nodeName = request.path().param("node");

        Health h = (Health) request.content().as(JsonObject.class).thenAccept(jo -> getHealthInfoFromJson(jo));

        statusService.updateEnvironment(envName, serviceName, nodeName, h);

        request.content().as(JsonObject.class).thenAccept(jo -> updateHealthInfoFromJson(jo)).thenAccept(jo -> response.status(204).send());
    }


    private Health updateHealthInfoFromJson(JsonObject jo) {
        String healthJson = jo.toString();
        Health myHealth = null;
        if (jo != null || jo.toString().length() < 1) {
            myHealth = HealthMapper.fromRealWorldJson(healthJson);
            statusService.updateHealthMap(myHealth);
        }
        return myHealth;
    }

    private Health getHealthInfoFromJson(JsonObject jo) {
        String healthJson = jo.toString();
        Health myHealth = null;
        if (jo != null || jo.toString().length() < 1) {
            myHealth = HealthMapper.fromRealWorldJson(healthJson);
        }
        return myHealth;
    }

    public StatusService getStatusService() {
        return statusService;
    }
}


package no.cantara.tools.visuale.status;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class StatusResource implements Service {

    private static final Logger logger = LoggerFactory.getLogger(StatusResource.class);

    private static final String ACCESS_TOKEN_PARAM_NAME = "accessToken";

    final StatusService statusService = new StatusService();

    final String accessToken;

    public StatusResource(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * A service registers itself by updating the routine rules.
     *
     * @param rules the routing rules.
     */
    @Override
    public void update(Routing.Rules rules) {
        rules.get("/status", this::showEnvironment)
                .options("/status", this::showEnvironmentOptionHeaders)
                .get("/api/status", this::showEnvironment)
                .options("/api/status", this::showEnvironmentOptionHeaders)
                .put("/status", this::updateHealthInfo)
                .put("/api/status", this::updateHealthInfo)
                .put("/status/{env}/{service}/{node}", this::updateFullHealthInfo)
                .put("/api/status/{env}/{service}/{node}", this::updateFullHealthInfo);
    }

    @SuppressWarnings("checkstyle:designforextension")
    public void showEnvironment(final ServerRequest request, final ServerResponse response) {
        if (accessToken != null && accessToken.length() > 0) {
            Optional<String> AccessTokenParam = request.queryParams().first(ACCESS_TOKEN_PARAM_NAME);
            // if code is not in the request, this is a problem
            try {
                if (!accessToken.equalsIgnoreCase(AccessTokenParam.get())) {
                    response.status(404).send("{\"reason\":\"unauthorized\"}");
                }
            } catch (Exception e) {
                response.status(404).send("{\"reason\":\"unauthorized\"}");
            }
        }
        String msg = statusService.getEnvironmentAsString();
        response.status(200).send(msg);
    }

    @SuppressWarnings("checkstyle:designforextension")
    public void showEnvironmentOptionHeaders(final ServerRequest request, final ServerResponse response) {
        response.status(200).headers().add("Content-Type: application/json"
                , "Access-Control-Allow-Origin: *"
                , "Access-Control-Allow-Methods: GET, OPTIONS"
                , "Access-Control-Allow-Headers: *"
                , "Access-Control-Allow-Credentials: true");
    }

    @SuppressWarnings("checkstyle:designforextension")
    public void updateHealthInfo(final ServerRequest request, final ServerResponse response) {
        logger.debug("updateHealthInfo");
        request.content().as(String.class)
                .thenAccept(jo -> updateHealthInfoFromJson(jo))
                .thenAccept(jo -> response.status(204).send());

    }

    private Health updateHealthInfoFromJson(String healthJsonString) {
        try {
            Health myHealth = null;
            if (healthJsonString != null || healthJsonString.length() < 1) {
                myHealth = HealthMapper.fromRealWorldJson(healthJsonString);
                statusService.queue(myHealth);
            }
            return myHealth;
        } catch (Exception e) {
            logger.error("Unable to patse and update health info for payload: {}, {}", healthJsonString, e);
        }
        return null;
    }

    @SuppressWarnings("checkstyle:designforextension")
    public void updateFullHealthInfo(final ServerRequest request, final ServerResponse response) {
        // TODO revisit this  foundService = true;

        logger.debug("updateFullHealthInfo");
        String envName = request.path().param("env");
        String serviceName = request.path().param("service");
        Map<String, List<String>> queryMap = request.queryParams().toMap();
        String serviceTag = "";
        if (queryMap.get("service_tag") != null) {
            serviceTag = queryMap.get("service_tag").get(0);
        }
        String sTa = serviceTag;
        String serviceType = "";
        if (queryMap.get("service_type") != null) {
            serviceType = queryMap.get("service_type").get(0);
        }
        String sTy = serviceType;
        String nodeName = request.path().param("node");
//        String sTa = "";
//        String sTy = "";

        request.content().as(String.class)
                .thenAccept(jo -> updateEnvironmentFromHealthInfoJson(jo, envName, serviceName, sTa, sTy, nodeName))
                .thenAccept(jo -> response.status(204).send());
    }

    private Health updateEnvironmentFromHealthInfoJson(String healthJsonString, String envName, String serviceName, String serviceTag, String serviceType, String nodeName) {
        try {
            Health myHealth = null;
            if (healthJsonString != null || healthJsonString.length() < 1) {
                myHealth = HealthMapper.fromRealWorldJson(healthJsonString);
            }
            if (myHealth != null && myHealth.getRunningSince() != null && myHealth.getRunningSince().length() > 5) {
                statusService.queueEnvironmentUpdate(envName, serviceName, serviceTag, serviceType, nodeName, myHealth);
            }
            return myHealth;
        } catch (Exception e) {
            logger.error("Unable to parse and update health info for payload: {}, {}", healthJsonString, e);
        }
        return null;
    }

    public StatusService getStatusService() {
        return statusService;
    }
}


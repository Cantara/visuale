package no.cantara.tools.visuale.status;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

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

        Map<String, List<String>> queryMap = request.queryParams().toMap();
        String serviceTag = "";
        if (queryMap.get("service_tag") != null) {
            serviceTag = queryMap.get("service_tag").get(0);
        }
        final String sTa = serviceTag;
        String serviceType = "";
        if (queryMap.get("service_type") != null) {
            serviceType = queryMap.get("service_type").get(0);
        }
        final String sTy = serviceType;
        String serviceName = "";
        if (queryMap.get("service_name") != null) {
            serviceName = queryMap.get("service_name").get(0);
        }
        final String sNa = serviceName;

        // Attempt to capture sender IP if reported ip=10.10.10.10 or missing
        Map<String, List<String>> headerMap = request.headers().toMap();
        String xff = "";
        if (headerMap.get("X-Forwarded-For") != null) {
            xff = headerMap.get("X-Forwarded-For").get(0);
        }
        final String sXff = xff;

        request.content().as(String.class)
                .thenApply(this::jsonToHealth)
                .thenAccept(health -> {
                    if (health == null) {
                        response.status(400).send("Missing json health in body.");
                        return;
                    }
                    if (hasValue(sNa)) {
                        health.setServiceName(sNa);
                    }
                    if (hasValue(sTy)) {
                        health.setServiceType(sTy);
                    }
                    if (hasValue(sTa)) {
                        health.setServiceTag(sTa);
                    }
                    if (health.getIp() == null ||
                            health.getIp().length() < 5 ||
                            health.getIp().equalsIgnoreCase("10.10.10.10") ||
                            health.getIp().equalsIgnoreCase("0.0.0.0")) {
                        health.setIp(sXff);
                    }
                    List<String> missingFields = new ArrayList<>();
                    if (!hasValue(health.getServiceName())) {
                        missingFields.add("service_name");
                    }
                    if (!hasValue(health.getServiceTag())) {
                        missingFields.add("service_tag");
                    }
                    if (!hasValue(health.getServiceType())) {
                        missingFields.add("service_type");
                    }
                    if (!hasValue(health.getName())) {
                        missingFields.add("name");
                    }
                    if (missingFields.size() > 0) {
                        response.status(400).send("Health is missing fields: " + String.join(",", missingFields));
                        return;
                    }

                    statusService.queue(new NodeHealthData(statusService.getEnvironmentName(), health.getServiceName(),
                            health.getServiceTag(), health.getServiceType(), health.getName(), health));

                    response.status(204).send();

                })
                .exceptionallyAccept(t -> {
                    response.status(400).send("Unable to deserialize body as valid health json");
                });
    }

    private Health jsonToHealth(String healthJsonString) {
        Health myHealth = null;
        if (healthJsonString != null || healthJsonString.length() < 1) {
            myHealth = HealthMapper.fromRealWorldJson(healthJsonString);
        }
        return myHealth;
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
                .thenApply(this::jsonToHealth)
                .thenAccept(health -> {
                    if (health != null) {
                        statusService.queueNodeHealth(envName, serviceName, sTa, sTy, nodeName, health);
                    }
                })
                .thenAccept(v -> response.status(204).send());
    }

    public StatusService getStatusService() {
        return statusService;
    }
}


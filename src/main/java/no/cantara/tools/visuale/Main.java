package no.cantara.tools.visuale;

import io.helidon.media.jackson.JacksonSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;
import io.helidon.webserver.staticcontent.StaticContentSupport;
import no.cantara.config.ApplicationProperties;
import no.cantara.tools.visuale.healthchecker.HealthCheckProber;
import no.cantara.tools.visuale.status.StatusResource;
import no.cantara.tools.visuale.status.StatusService;
import no.cantara.tools.visuale.utils.EnvironmentConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.logging.LogManager;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

/**
 * The application main class.
 */
public final class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    private final String accessToken;
    private final String applicationInstanceName = "visuale";
    private final Instant server_started = Instant.now();
    private final StatusResource statusResource;
    private final HealthResource healthResource;

    /**
     * Cannot be instantiated.
     */
    public Main(String accessToken) {
        this.accessToken = accessToken;
        statusResource = new StatusResource(accessToken);
        healthResource = new HealthResource();
    }

    /**
     * Application main entry point.
     *
     * @param args command line arguments
     * @throws IOException if there are problems reading logging properties
     */
    public static void main(final String[] args) throws IOException {
        // load logging configuration
        setupLogging();
//        Config config = ConfigProvider.getConfig();

        ApplicationProperties.builder().defaults().buildAndSetStaticSingleton();
        int portNo = ApplicationProperties.getInstance().asInt("server.port", 8080);

        String accessToken = ApplicationProperties.getInstance().get("server.accessToken");

        Main main = new Main(accessToken);

        WebServer ws = main.startServer(portNo, getConfiguredContextPath(), false);
    }

    public static String getConfiguredContextPath() {
        String serverContextPath = ApplicationProperties.getInstance().get("server.context-path", "");
        String contextPath = serverContextPath.endsWith("/") ? serverContextPath.substring(0, serverContextPath.length() - 1) : serverContextPath;
        return contextPath;
    }

    /**
     * Start the server.
     *
     * @return the created {@link WebServer} instance
     */
    public WebServer startServer(int port, String contextPath, boolean usingMockEnvironment) {
        if (usingMockEnvironment) {
            statusResource.getStatusService().queueFullEnvironment(MOCK_ENVORONMENT, "Visuale DEVTEST");
            startHealthReportSimulator(healthResource, statusResource.getStatusService(), null);

        } else {
            EnvironmentConfig environmentConfig = new EnvironmentConfig();
            statusResource.getStatusService().queue(environmentConfig.getEnvironment());
            startHealthReportSimulator(healthResource, statusResource.getStatusService(), environmentConfig);
        }

        return startServer(port, contextPath);
    }

    public WebServer startServer(int port, String contextPath) {

        Routing routing = Routing.builder()
                .register(contextPath, healthResource)
                .register(contextPath, statusResource)
                .register(contextPath + "/favicon.ico", StaticContentSupport.builder("/nuxt-spa/dist/favicon.ico")
                        .build())
                .register(contextPath + "/nuxt-spa", StaticContentSupport.builder("/nuxt-spa")
                        .build())
                .register(contextPath + "/_nuxt", StaticContentSupport.builder("/nuxt-spa/dist/_nuxt")
                        .build())
                .register(contextPath + "/", StaticContentSupport.builder("/nuxt-spa/dist")
                        .welcomeFileName("index.html")
                        .build())
                .build();

        WebServer ws = WebServer.builder()
                .port(port)
                .addMediaSupport(JacksonSupport.create())
                .routing(routing)
                .build();

        // start the server
        //Server server = startServer();
        ws.start()
                .thenApply(webServer -> {
                            if (accessToken == null || accessToken.length() < 1) {
                                String endpoint = "http://localhost:" + webServer.port() + contextPath;
                                System.out.println("- Visit Dashboard at: " + endpoint + "/?ui_extension=groupByTag&servicetype=true");
                                System.out.println(" - Health checks available on: " + endpoint + "/health");
                                System.out.println(" - Environment status available on:  " + endpoint + "/status/");
                            } else {
                                String endpoint = "http://localhost:" + webServer.port() + contextPath;
                                System.out.println(" Visit Dashboard at: " + endpoint + "/?accessToken=" + accessToken + "&ui_extension=groupByTag&servicetype=true");
                                System.out.println(" - Health checks available on: " + endpoint + "/health");
                                System.out.println(" - Environment status available on:  " + endpoint + "/status/?accessToken=" + accessToken);

                            }
                            return null;
                        }
                );
        return ws;
    }

    /**
     * Configure logging from logging.properties file.
     */
    private static void setupLogging() throws IOException {
        try (InputStream is = Main.class.getResourceAsStream("/logging.properties")) {
            LogManager.getLogManager().readConfiguration(is);
        }
    }

    private void startHealthReportSimulator(HealthResource healthResource, StatusService statusService, EnvironmentConfig environmentConfig) {
        HealthCheckProber prober = new HealthCheckProber(healthResource, statusService, environmentConfig);
        prober.startScheduler();
    }

    public void shutdown() {
        statusResource.getStatusService().shutdown();
    }

    public StatusResource getStatusResource() {
        return statusResource;
    }

    public HealthResource getHealthResource() {
        return healthResource;
    }
}

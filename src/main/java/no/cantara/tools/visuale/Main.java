package no.cantara.tools.visuale;

import io.helidon.media.jsonb.server.JsonBindingSupport;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;
import no.cantara.config.ServiceConfig;
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
    private static String applicationInstanceName = "visuale";
    private static final int SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS = 2;
    private static final Instant server_started = Instant.now();

    private static final StatusResource statusResource = new StatusResource();

    /**
     * Cannot be instantiated.
     */
    private Main() {
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
        String port = ServiceConfig.getProperty("server.port");
        int portNo = 8080;
        try {
            portNo = Integer.parseInt(port);
        } catch (Exception e) {
            log.error("Unable to find config property for server.port, found:{} - using fallbackvalue ", port, portNo);
        }

        WebServer ws = startServer(portNo, false);
    }


    /**
     * Start the server.
     *
     * @return the created {@link WebServer} instance
     */
    static public WebServer startServer(int port, boolean usingMockEnvironment) {

        if (usingMockEnvironment) {
            statusResource.getStatusService().initializeEnvironment(MOCK_ENVORONMENT, "Visuale DEVTEST");
        } else {
            EnvironmentConfig environmentConfig = new EnvironmentConfig();
            statusResource.getStatusService().initializeEnvironment(environmentConfig.getEnvironment(), environmentConfig.getEnvironmentName());
        }
        startHealthReportSimulator(statusResource.getStatusService());


        HealthResource healthResource = new HealthResource();
        Routing routing = Routing.builder()
                .register(JsonBindingSupport.create())
                .register(healthResource)
                .register(statusResource)
                .register("/", StaticContentSupport.builder("/nuxt-spa/dist")
                        .welcomeFileName("index.html")
                        .build())
                .build();

        ServerConfiguration serverConfig = null;
        if (port != 0) {
            serverConfig = ServerConfiguration.builder().port(port)
                    .build();

        } else {
            serverConfig = ServerConfiguration.builder()
                    .build();

        }
        WebServer ws = WebServer.create(serverConfig, routing);
        // start the server
        //Server server = startServer();
        ws.start()
                .thenApply(webServer -> {
                    String endpoint = "http://localhost:" + webServer.port();
                    System.out.println("Visit Dashboard at: " + endpoint + "/");
                    System.out.println("Health checks available on: " + endpoint + "/health");
                    System.out.println("Environment status available on:  " + endpoint + "/status/");
                    return null;
                });
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

    private static void startHealthReportSimulator(StatusService statusService) {
        HealthCheckProber prober = new HealthCheckProber(statusService);
        prober.startScheduler();
    }


}

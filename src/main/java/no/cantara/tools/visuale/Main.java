package no.cantara.tools.visuale;

import io.helidon.media.jsonb.server.JsonBindingSupport;
import io.helidon.microprofile.server.Server;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;
import no.cantara.tools.visuale.healthchecker.HealthCheckProber;
import no.cantara.tools.visuale.status.StatusResource;
import no.cantara.tools.visuale.status.StatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.time.Instant;
import java.util.Enumeration;
import java.util.Properties;
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

        WebServer ws = startServer(8080, true);
    }


    /**
     * Start the server.
     *
     * @return the created {@link Server} instance
     */
    static public Server startMPServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        // and Application classes annotated as @ApplicationScoped
        return Server.create().start();
    }


    /**
     * Start the server.
     *
     * @return the created {@link Server} instance
     */
    static public WebServer startServer(int port, boolean usingMockEnvironment) {

        StatusResource statusResource;
        if (usingMockEnvironment) {
            statusResource = new StatusResource();
            statusResource.getStatusService().initializeEnvironment(MOCK_ENVORONMENT, "Visuale DEVTEST");
        } else {
            statusResource = new StatusResource();
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


    private static String getVersion() {
        Properties mavenProperties = new Properties();
        String resourcePath = "/META-INF/maven/no.cantara.tools/visuale/pom.properties";
        URL mavenVersionResource = Main.class.getResource(resourcePath);
        if (mavenVersionResource != null) {
            try {
                mavenProperties.load(mavenVersionResource.openStream());
                return mavenProperties.getProperty("version", "missing version info in " + resourcePath);
            } catch (IOException e) {
                log.warn("Problem reading version resource from classpath: ", e);
            }
        }
        return "(DEV VERSION)" + " [" + applicationInstanceName + " - " + getMyIPAddresssesString() + "]";
    }

    public static String getMyIPAddresssesString() {
        String ipAdresses = "";

        try {
            ipAdresses = InetAddress.getLocalHost().getHostAddress();
            Enumeration n = NetworkInterface.getNetworkInterfaces();

            while (n.hasMoreElements()) {
                NetworkInterface e = (NetworkInterface) n.nextElement();

                InetAddress addr;
                for (Enumeration a = e.getInetAddresses(); a.hasMoreElements(); ipAdresses = ipAdresses + "  " + addr.getHostAddress()) {
                    addr = (InetAddress) a.nextElement();
                }
            }
        } catch (Exception var5) {
            ipAdresses = "Not resolved";
        }

        return ipAdresses;
    }

    public static String getMyIPAddresssString() {
        String fullString = getMyIPAddresssesString();
        return fullString.substring(0, fullString.indexOf(" "));
    }

    private static void startHealthReportSimulator(StatusService statusService) {
        HealthCheckProber prober = new HealthCheckProber(statusService);
        prober.startScheduler();
    }


}

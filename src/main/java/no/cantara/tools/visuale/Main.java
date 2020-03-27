package no.cantara.tools.visuale;

import io.helidon.health.HealthSupport;
import io.helidon.health.checks.HealthChecks;
import io.helidon.microprofile.server.Server;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;
import no.cantara.tools.visuale.status.StatusResource;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.logging.LogManager;

/**
 * The application main class.
 */
public final class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);
    private static String applicationInstanceName = "visuale";

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

        HealthSupport health = HealthSupport.builder()
                .add(HealthChecks.healthChecks())
                .add((HealthCheck) () -> HealthCheckResponse.named("exampleHealthCheck")
                        .up()
                        .withData("time", System.currentTimeMillis())
                        .withData("version", getVersion())
                        .build())
                .build();

        Routing routing = Routing.builder()
                .register(health)
                .get("/hello", (req, res) -> res.send("Hello World!"))
                .get("/status", (req, res) -> res.send(statusResource.getStatusMessage()))
                .register("/", StaticContentSupport.builder("/staticspa")
                        .welcomeFileName("index.html")
                        .build())
//                .register("/",new StatusResource())
                .build();

        ServerConfiguration serverConfig = ServerConfiguration.builder().port(8080)
                .build();

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
    }

    /**
     * Start the server.
     *
     * @return the created {@link Server} instance
     */
    static Server startServer() {
        // Server will automatically pick up configuration from
        // microprofile-config.properties
        // and Application classes annotated as @ApplicationScoped
        return Server.create().start();
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
                return mavenProperties.getProperty("version", "missing version info in " + resourcePath) + " [" + applicationInstanceName + " - " + getMyIPAddresssesString() + "]";
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
}

package no.cantara.tools.visuale;

import io.helidon.health.HealthSupport;
import io.helidon.health.checks.HealthChecks;
import io.helidon.media.jsonb.server.JsonBindingSupport;
import io.helidon.microprofile.server.Server;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.StaticContentSupport;
import io.helidon.webserver.WebServer;
import no.cantara.tools.visuale.domain.Health;
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
import java.time.Instant;
import java.util.Enumeration;
import java.util.Properties;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
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
        startHealthReportSimulator();

        StatusResource statusResource;
        if (usingMockEnvironment) {
            statusResource = new StatusResource();
            statusResource.getStatusService().initializeEnvironment(MOCK_ENVORONMENT, "Visuale DEVTEST");
        } else {
            statusResource = new StatusResource();
        }


        HealthSupport health = HealthSupport.builder()
                .add(HealthChecks.healthChecks())
                .add((HealthCheck) () -> HealthCheckResponse.named("exampleHealthCheck")
                        .up()
                        .withData("time", System.currentTimeMillis())
                        .withData("version", getVersion())
                        .build())
                .build();

        Routing routing = Routing.builder()
                .register(JsonBindingSupport.create())
                .register(health)
                .register(statusResource)
                .register("/", StaticContentSupport.builder("/staticspa")
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

    private static void startHealthReportSimulator() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);

        Runnable task1 = () -> {

            Health health = new Health().withName(applicationInstanceName + "-service").withVersion(getVersion()).withStatus("OK")
                    .withIp(getMyIPAddresssString())
                    .withNow(Instant.now().toString()).withRunningSince(server_started.toString())
                    .withAdditionalProperty("simulated", "true");
            statusResource.getStatusService().updateHealthMap(health);
        };

        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 15, SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);


        ScheduledExecutorService ses2 = Executors.newScheduledThreadPool(1);

        Runnable task2 = () -> {


            Health health = new Health().withName(applicationInstanceName + "-service").withVersion(getVersion()).withStatus("OK")
                    .withIp(getMyIPAddresssString().replace("3", "4"))
                    .withNow(Instant.now().toString()).withRunningSince(server_started.toString())
                    .withAdditionalProperty("simulated", "true");
            statusResource.getStatusService().updateHealthMap(health);
        };

        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture2 = ses2.scheduleAtFixedRate(task2, 35, 5 + SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);
        ScheduledExecutorService ses3 = Executors.newScheduledThreadPool(1);
        Runnable task3 = () -> {


            Health health = new Health().withName(applicationInstanceName + "-service").withVersion(getVersion()).withStatus("OK")
                    .withIp(getMyIPAddresssString().replace("4", "5"))
                    .withNow(Instant.now().toString()).withRunningSince(server_started.toString())
                    .withAdditionalProperty("simulated", "true");
            statusResource.getStatusService().updateHealthMap(health);
        };

        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture3 = ses3.scheduleAtFixedRate(task3, 12, 3 + SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);

        ScheduledExecutorService ses4 = Executors.newScheduledThreadPool(1);
        Runnable task4 = () -> {


            Health health = new Health().withName(applicationInstanceName + "-service").withVersion(getVersion()).withStatus("OK")
                    .withIp(getMyIPAddresssString().replace("5", "6"))
                    .withNow(Instant.now().toString()).withRunningSince(server_started.toString())
                    .withAdditionalProperty("simulated", "true");
            statusResource.getStatusService().updateHealthMap(health);
        };

        // init Delay = 5, repeat the task every 60 second
        ScheduledFuture<?> scheduledFuture4 = ses4.scheduleAtFixedRate(task4, 11, 2 + SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);
    }

}

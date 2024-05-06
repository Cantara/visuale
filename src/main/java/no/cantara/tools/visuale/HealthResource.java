package no.cantara.tools.visuale;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.URI;
import java.net.URL;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class HealthResource implements Service {
    public static final Logger log = LoggerFactory.getLogger(HealthResource.class);
    public static final String applicationInstanceName = "visuale";

    private final boolean ok = true;
    private final Set<URI> okPollingURLs = new CopyOnWriteArraySet<>();
    private final Set<URI> failedPollingURLs = new CopyOnWriteArraySet<>();
    private final String runningSince;
    private final String myVersion;
    private final String myIp;

    public HealthResource() {
        runningSince = getRunningSince();
        myVersion = getVersion();
        myIp = getMyIPAddresssString();
    }

    /**
     * A service registers itself by updating the routine rules.
     *
     * @param rules the routing rules.
     */
    @Override
    public void update(Routing.Rules rules) {
        rules.get("/health", this::showEnvironment)
                .get("/api/health", this::showEnvironment);
    }


    /**
     * Return a wordly greeting message.
     */
    @SuppressWarnings("checkstyle:designforextension")
    public void showEnvironment(final ServerRequest request, final ServerResponse response) {
        String msg = getHealthTextJson();
        response.status(200).send(msg);
    }


    public String getHealthTextJson() {
        return "{\n" +
                "  \"Status\": \"" + ok + "\",\n" +
                "  \"name\": \"" + applicationInstanceName + "\",\n" +
                "  \"ip\": \"" + myIp + "\",\n" +
                "  \"version\": \"" + myVersion + "\",\n" +
                "  \"okPollingURLs\": \"" + Arrays.asList(okPollingURLs) + "\",\n" +
                "  \"failedPollingURLs\": \"" + Arrays.asList(failedPollingURLs) + "\",\n" +
                "  \"now\": \"" + Instant.now() + "\",\n" +
                "  \"running since\": \"" + runningSince + "\"\n\n" +
                "}\n";
    }

    public static String getRunningSince() {
        long uptimeInMillis = ManagementFactory.getRuntimeMXBean().getUptime();
        return Instant.now().minus(uptimeInMillis, ChronoUnit.MILLIS).toString();
    }

    private String getVersion() {
        Properties mavenProperties = new Properties();
        String resourcePath = "/META-INF/maven/no.cantara.tools/" + applicationInstanceName + "/pom.properties";
        URL mavenVersionResource = HealthResource.class.getResource(resourcePath);
        if (mavenVersionResource != null) {
            try {
                mavenProperties.load(mavenVersionResource.openStream());
                return mavenProperties.getProperty("version", "missing version info in " + resourcePath);
            } catch (IOException e) {
                log.warn("Problem reading version resource from classpath: ", e);
            }
        }
        return "(DEV VERSION)" + " [" + applicationInstanceName + " - " + getMyIPAddresssString() + "]";
    }

    public static String getMyIPAddresssesString() {

        String ipAdresses;

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
        } catch (Exception e) {
            return "Not resolved";
        }

        return ipAdresses;
    }

    public static String getMyIPAddresssString() {
        String fullString = getMyIPAddresssesString();
        return fullString.substring(0, fullString.indexOf(" "));
    }

    public void setOkPollingURLs(Set<URI> okPollingURLs) {
        this.okPollingURLs.clear();
        this.okPollingURLs.addAll(okPollingURLs);
    }

    public void setFailedPollingURLs(Set<URI> failedPollingURLs) {
        this.failedPollingURLs.clear();
        this.failedPollingURLs.addAll(failedPollingURLs);
    }
}
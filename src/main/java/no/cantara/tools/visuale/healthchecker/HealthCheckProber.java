package no.cantara.tools.visuale.healthchecker;

import no.cantara.tools.visuale.HealthResource;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import no.cantara.tools.visuale.status.StatusService;
import no.cantara.tools.visuale.utils.EnvironmentConfig;
import no.cantara.tools.visuale.utils.config.ConfEnv;
import no.cantara.tools.visuale.utils.config.ConfNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.net.URI;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;

public class HealthCheckProber {

    public static final Logger logger = LoggerFactory.getLogger(HealthCheckProber.class);

    private static final int SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS = 10;

    private final Set<ConfNode> healthCheckURLSet = new CopyOnWriteArraySet<>();
    private final Set<ConfNode> environmentPathSet = new CopyOnWriteArraySet<>();
    private final Map<URI, ConfNode> environmentPathMap = new ConcurrentHashMap<>();
    private final Set<ConfNode> badHealthCheckURLSet = new CopyOnWriteArraySet<>();
    private final StatusService statusService;
    private final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    private final HealthResource healthResource;

    public int getOkHealthCheckMapSize() {
        return healthCheckURLSet.size();
    }

    public int getErroredHealthCheckMapSize() {
        return badHealthCheckURLSet.size();
    }

    Runnable checkHealthTask = null;

    public HealthCheckProber(HealthResource healthResource, StatusService statusService, EnvironmentConfig environmentConfig) {
        this.healthResource = healthResource;
        this.statusService = statusService;
        readConfig(environmentConfig);
        Set<URI> checkSet = new CopyOnWriteArraySet<>();
        for (ConfNode uri : healthCheckURLSet) {
            checkSet.add(URI.create(uri.getHealthUrl()));
        }
        healthResource.setOkPollingURLs(checkSet);
        Set<URI> badSet = new CopyOnWriteArraySet<>();
        for (ConfNode uri : badHealthCheckURLSet) {
            badSet.add(URI.create(uri.getHealthUrl()));
        }
        healthResource.setFailedPollingURLs(badSet);
        checkHealthTask = () -> {
            checkHealth();
        };
    }


    public void startScheduler() {
        if (healthCheckURLSet.size() > 0) {

            ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(checkHealthTask, 55, SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);
        }
    }

    private void readConfig(EnvironmentConfig environmentConfig) {
        if (environmentConfig != null) {
            ConfEnv confEnv = environmentConfig.getConfEnv();
            if (confEnv != null && confEnv.getNodes() != null) {
                for (ConfNode s : confEnv.getNodes()) {
                    try {
                        URI pollingURI = URI.create(s.getHealthUrl());
                        environmentPathMap.put(pollingURI, s);
                        environmentPathSet.add(s);
                        healthCheckURLSet.add(s);
                    } catch (Exception e) {
                        logger.warn("Found illegal URL in config: ", e);
                    }
                }
            }
        } else {
            environmentConfig = new EnvironmentConfig();
        }

        if (environmentConfig.getEnvironment() == null || environmentConfig.getEnvironmentAsString().length() < 40) {

            Path fileName = new File("./add_health_resources.txt").toPath();
            try (Scanner scanner = new Scanner(fileName)) {
                while (scanner.hasNextLine()) {
                    String healthURL = scanner.nextLine();
                    if (healthURL != null && healthURL.length() > 10 && !healthURL.startsWith("#")) {
                        ConfNode confNode = new ConfNode();
                        confNode.setHealthUrl(healthURL);
                        healthCheckURLSet.add(confNode);
                        environmentPathSet.add(confNode);
                        URI url = new URI(healthURL);
                        environmentPathMap.put(url, confNode);
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to parse data from add_health_resources.txt", e);
            }
        }
    }


    public void checkHealth() {
        for (ConfNode u : healthCheckURLSet) {
            try {
                String json = new CommandGetHealthJson(URI.create(u.getHealthUrl())).execute();
                if (json != null && !json.toLowerCase().contains("html")) {
                    Health health = HealthMapper.fromRealWorldJson(json);
                    health.setProbedFrom("Visuale on " + HealthResource.getMyIPAddresssString());
                    ConfNode confNode;
                    if (environmentPathSet.contains(u)) {
                        confNode = u;
                    } else {
                        confNode = environmentPathMap.get(u.getHealthUrl());
                    }
                    String serviceName = confNode.getServiceName();
                    String serviceTag = confNode.getServiceTag();
                    String serviceType = confNode.getServiceType();
                    String nodeName = confNode.getNodeName();
                    statusService.queueNodeHealth("env", serviceName, serviceTag, serviceType, nodeName, health);
                } else {
                    logger.error("   ==> 1 Unable to parse json from {} ", u);
                    // We reduce noise on wrong urls by removing them right now
//                    healthCheckURLSet.remove(u);
//                    badHealthCheckURLSet.add(u);
                }
            } catch (Exception e) {
                logger.error("==> Unable to parse json from {} - exception ", u, e);
                // We reduce noise on wrong urls by removing them right now
//                healthCheckURLSet.remove(u);
//                badHealthCheckURLSet.add(u);
            }
        }
        if (badHealthCheckURLSet.size() > 1) {
            logger.warn("===> bad health URL list:{}", Arrays.asList(badHealthCheckURLSet.toArray()));
        }
        int random = ThreadLocalRandom.current().nextInt(100);
        if (random > 90) {
            logger.info("==> Decided to re-add the bad URLs for a retry.  Added {} urls", badHealthCheckURLSet.size());
            healthCheckURLSet.addAll(badHealthCheckURLSet);
            badHealthCheckURLSet.clear();
        }

        Set<URI> okURLSet = new CopyOnWriteArraySet<>();
        for (ConfNode c : healthCheckURLSet) {
            okURLSet.add(URI.create(c.getHealthUrl()));
        }
        healthResource.setOkPollingURLs(okURLSet);
        Set<URI> failURLSet = new CopyOnWriteArraySet<>();
        for (ConfNode c : badHealthCheckURLSet) {
            okURLSet.add(URI.create(c.getHealthUrl()));
        }
        healthResource.setFailedPollingURLs(failURLSet);

    }
}

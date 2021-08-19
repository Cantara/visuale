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
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class HealthCheckProber {

    public static final Logger logger = LoggerFactory.getLogger(HealthCheckProber.class);

    private static final int SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS = 10;

    private final Set<URI> healthCheckURLSet = new CopyOnWriteArraySet<>();
    private final Map<URI, ConfNode> environmentPathMap = new ConcurrentHashMap<>();
    private final Set<URI> badHealthCheckURLSet = new CopyOnWriteArraySet<>();
    private final StatusService statusService;
    private final ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    private final HealthResource healthResource;

    public int getOkHealthCheckMapSize() {
        return healthCheckURLSet.size();
    }

    public int getErroredHealthCheckMapSize() {
        return badHealthCheckURLSet.size();
    }

    public HealthCheckProber(HealthResource healthResource, StatusService statusService, EnvironmentConfig environmentConfig) {
        this.healthResource = healthResource;
        this.statusService = statusService;
        readConfig(environmentConfig);
        healthResource.setOkPollingURLs(healthCheckURLSet);
        healthResource.setFailedPollingURLs(badHealthCheckURLSet);
    }

    public void startScheduler() {
        if (healthCheckURLSet.size() > 0) {
            ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(this::checkHealth, 5, SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);
        }
    }

    private void readConfig(EnvironmentConfig environmentConfig) {
        if (environmentConfig != null) {
            ConfEnv confEnv = environmentConfig.getConfEnv();
            for (ConfNode s : confEnv.getNodes()) {
                try {
                    URI pollingURI = URI.create(s.getHealthUrl());
                    environmentPathMap.put(pollingURI, s);
                    healthCheckURLSet.add(pollingURI);
                } catch (Exception e) {
                    logger.warn("Found illegal URL in config: ", e);
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
                        URI url = new URI(healthURL);
                        healthCheckURLSet.add(url);
                    }
                }
            } catch (Exception e) {
                logger.error("Unable to parse data from add_health_resources.txt", e);
            }
        }
    }


    public void checkHealth() {
        for (URI u : healthCheckURLSet) {
            try {
                String json = new CommandGetHealthJson(u).execute();
                if (json != null && !json.toLowerCase().contains("html")) {
                    Health health = HealthMapper.fromRealWorldJson(json);
                    ConfNode confNode = environmentPathMap.get(u);
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
        healthResource.setOkPollingURLs(healthCheckURLSet);
        healthResource.setFailedPollingURLs(badHealthCheckURLSet);

    }
}

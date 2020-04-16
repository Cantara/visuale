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
import java.util.*;
import java.util.concurrent.*;

public class HealthCheckProber {

    public static final Logger logger = LoggerFactory.getLogger(HealthCheckProber.class);
    private static final int SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS = 2;
    private static boolean scheduler_running = false;

    private static Set<URI> healthCheckURLSet = new CopyOnWriteArraySet<>();
    Map<URI, ConfNode> environmentPathMap = new HashMap<>();
    private static Set<URI> badHealthCheckURLSet = new CopyOnWriteArraySet<>();
    private static StatusService statusService;
    private static ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

    public int getOkHealthCheckMapSize() {
        return healthCheckURLSet.size();
    }

    public int getErroredHealthCheckMapSize() {
        return badHealthCheckURLSet.size();
    }

    public HealthCheckProber(StatusService statusService) {
        this.statusService = statusService;
        readConfig();
        HealthResource.setOkPollingURLs(healthCheckURLSet);
        HealthResource.setFailedPollingURLs(badHealthCheckURLSet);

    }

    public void startScheduler() {
        if (healthCheckURLSet.size() > 0 && !scheduler_running) {
            scheduler_running = true;
            Runnable task1 = () -> {
                checkHealth();
            };
            // init Delay = 5, repeat the task every 60 second
            ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 15, SECONDS_BETWEEN_SCHEDULED_IMPORT_RUNS, TimeUnit.SECONDS);

        }

    }

    private void readConfig() {
        ConfEnv confEnv = new ConfEnv();
        for (ConfNode s : confEnv.getNodes()) {
            try {
                URI pollingURI = URI.create(s.getHealthUrl());
                environmentPathMap.put(pollingURI, s);
                healthCheckURLSet.add(pollingURI);
            } catch (Exception e) {
                logger.warn("Found illegal URL in config: ", e);
            }
        }
        EnvironmentConfig environmentConfig = new EnvironmentConfig();

        if (environmentConfig.getEnvironment() == null || environmentConfig.getEnvironment().length() < 40) {

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
                    String service = environmentPathMap.get(u).getServiceName();
                    String node = environmentPathMap.get(u).getNodeName();
                    statusService.updateEnvironment("env", service, node, health);
                } else {
                    logger.error("   ==> 1 Unable to parse json from {} ", u);
                    // We reduce noise on wrong urls by removing them right now
                    healthCheckURLSet.remove(u);
                    badHealthCheckURLSet.add(u);
                }
            } catch (Exception e) {
                logger.error("==> Unable to parse json from {} - exception ", u, e);
                // We reduce noise on wrong urls by removing them right now
                healthCheckURLSet.remove(u);
                badHealthCheckURLSet.add(u);
            }
        }
        if (badHealthCheckURLSet.size() > 1) {
            logger.warn("===> bad health URL list:{}", Arrays.asList(badHealthCheckURLSet.toArray()));
        }
        int random = ThreadLocalRandom.current().nextInt(100);
        if (random > 90) {
            logger.info("==> Decided to re-add the bad URLs for a retry.  Added {} urls", badHealthCheckURLSet.size());
            healthCheckURLSet.addAll(badHealthCheckURLSet);
            badHealthCheckURLSet = new CopyOnWriteArraySet();
        }
        HealthResource.setOkPollingURLs(healthCheckURLSet);
        HealthResource.setFailedPollingURLs(badHealthCheckURLSet);

    }
}

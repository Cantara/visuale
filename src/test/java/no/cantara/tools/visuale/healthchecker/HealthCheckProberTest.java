package no.cantara.tools.visuale.healthchecker;

import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.HealthMapper;
import no.cantara.tools.visuale.status.StatusService;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.time.Instant;

class HealthCheckProberTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    @Test
    public void testHealthCheckProber() {
        StatusService s = new StatusService();
        HealthCheckProber p = new HealthCheckProber(s, null);
        p.checkHealth();
        System.out.println("OK healthchecks:" + p.getOkHealthCheckMapSize());
        System.out.println("Error healthchecks:" + p.getErroredHealthCheckMapSize());

    }

    @Test
    void checkHealthCommand() {
        System.out.println(Instant.now());
        String url = "https://whydahdev.cantara.no/sso/health";
        String responseJson = new CommandGetHealthJson(URI.create(url)).execute();
        System.out.println(Instant.now());
        System.out.println(responseJson);
        Health h = HealthMapper.fromRealWorldJson(responseJson);
        System.out.println(Instant.now());
        System.out.println(h);
    }


}
package no.cantara.tools.visuale.status;

import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

class StatusServiceTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    @Test
    public void testenvServiceNodehealthMatching() {
        Health h = new Health().withNow(Instant.now().toString()).withIp("10.10.10.10").withName("test");
        StatusService s = new StatusService();
        s.queueEnvironmentUpdate("env", "service", "tag1", "", "n1", h);
        s.queueEnvironmentUpdate("env", "service", "tag2", "", "n1", h);
        s.queueEnvironmentUpdate("env", "service", "", "", "n2", h);
        s.queueEnvironmentUpdate("env", "service", "", "", "n3", h);
        s.queueEnvironmentUpdate("env", "service", "", "", "n4", h);
        s.queueEnvironmentUpdate("env", "service", "", "", "n5", h);
        s.waitForEvents(5, TimeUnit.SECONDS);
        System.out.println(s.getEnvironmentAsString());
    }
}
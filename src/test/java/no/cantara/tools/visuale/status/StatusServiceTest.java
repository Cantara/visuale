package no.cantara.tools.visuale.status;

import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.Test;

import java.time.Instant;

class StatusServiceTest {

    @Test
    public void testenvServiceNodehealthMatching() {
        Health h = new Health().withNow(Instant.now().toString()).withIp("10.10.10.10").withName("test");
        StatusService s = new StatusService();
        s.updateEnvironment("env", "service", "n1", h);
        s.updateEnvironment("env", "service", "n2", h);
        s.updateEnvironment("env", "service", "n3", h);
        s.updateEnvironment("env", "service", "n4", h);
        s.updateEnvironment("env", "service", "n5", h);
        System.out.println(s.getEnvironmentAsString());
    }
}
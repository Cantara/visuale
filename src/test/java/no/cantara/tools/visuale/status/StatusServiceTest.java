package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
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

    @Test
    public void thatSameServiceWithDifferentTagWorks() throws JsonProcessingException {
        String init1Json = readResourceAsString("inn/init-1.json");
        StatusService statusService = new StatusService();
        statusService.queueFullEnvironment(init1Json, "INN Dashboard");
        String health1Json = readResourceAsString("inn/inn-lwa-health-1.json");
        Health health1 = new ObjectMapper().readValue(health1Json, Health.class);
        statusService.queueEnvironmentUpdate("prod", "LoginWebApp", "SSO-Test", "H2A", "node2", health1);
        statusService.waitForEvents(5, TimeUnit.SECONDS);
        System.out.printf("%s%n", statusService.getEnvironmentAsString());
    }

    private String readResourceAsString(String path) {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(path)) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
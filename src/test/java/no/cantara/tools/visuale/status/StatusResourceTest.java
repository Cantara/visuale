package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

class StatusResourceTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    public static ObjectMapper mapper = new ObjectMapper();
    StatusService statusService = new StatusService();

    @Test
    public void testEnvironment() throws Exception {
        statusService.queueFullEnvironment(MOCK_ENVORONMENT, "JUnitTest Env");
        statusService.waitForEvents(5, TimeUnit.SECONDS);

        Environment environment = StatusService.mapper.readValue(statusService.getEnvironmentAsString(), Environment.class);

        for (int n = 10; n < 20; n++) {
            Health h = new Health().withIp("10.45.54." + n).withVersion("1.3." + n).withStatus("OK");
            statusService.queue(h);
        }
        for (int n = 10; n < 20; n++) {
            Health h = new Health().withIp("20.45.54." + n).withVersion("1.5." + n).withStatus("OK");
            statusService.queue(h);
        }
        statusService.waitForEvents(10, TimeUnit.SECONDS);
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment));
    }
}
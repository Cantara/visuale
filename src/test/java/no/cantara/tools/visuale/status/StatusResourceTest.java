package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import org.junit.jupiter.api.Test;

import java.util.Map;

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
        statusService.initializeEnvironment(MOCK_ENVORONMENT, "JUnitTest Env");
        Environment environment = statusService.getEnvironment();
        for (int n = 10; n < 20; n++) {
            Health h = new Health().withIp("10.45.54." + n).withVersion("1.3." + n).withStatus("OK");
            int result = statusService.updateHealthMap(h);
            System.out.println("n:" + n + " - r:" + result);
        }
        for (int n = 10; n < 20; n++) {
            Health h = new Health().withIp("20.45.54." + n).withVersion("1.5." + n).withStatus("OK");
            int result = statusService.updateHealthMap(h);
            System.out.println("n:" + n + " - r:" + result);
        }
        Map<String, Node> nodeMap = statusService.getHealthStatusMap();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(environment));
    }


}
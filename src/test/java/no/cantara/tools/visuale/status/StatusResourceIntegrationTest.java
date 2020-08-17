package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.webserver.WebServer;
import no.cantara.tools.visuale.Main;
import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.Arrays;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

public class StatusResourceIntegrationTest {
    private static WebServer server;
    public static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void startTheServer() throws Exception {
        server = Main.startServer(0, true);
        StatusService statusService = new StatusService();
        statusService.initializeEnvironment(MOCK_ENVORONMENT, "JUnitTest Env");
        //Thread.sleep(5000);
    }

    @Test()  // for some reason this fails in jenkins as of now
    public void testMockedServer() {

        try {
            Client client = ClientBuilder.newClient();

            String jsonObject = client
                    .target(getConnectionString("/status"))
                    .request()
                    .get(String.class);
            Assertions.assertTrue(jsonObject.length() > 5);

            Health h = new Health().withStatus("OK").withName("test-health").withVersion("0.2.1").withIp("10.3.2.30").withNow(Instant.now().toString());
            Response r = client
                    .target(getConnectionString("/api/status/myenv/myservice/mynode?servive_tag=mytag&service_type=ACS"))
                    .request()
                    .put(Entity.json(h));
            Assertions.assertEquals(204, r.getStatus(), "POST status code");

            r = client
                    .target(getConnectionString("/health"))
                    .request()
                    .get();
            Assertions.assertEquals(200, r.getStatus(), "GET health status code");
        } catch (Exception e) {
            System.out.println(Arrays.asList(e.getStackTrace()));
        }
    }

    @AfterAll
    public static void destroyClass() {
        //  CDI<Object> current = CDI.current();
        //  ((SeContainer) current).close();
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + path;
    }
}


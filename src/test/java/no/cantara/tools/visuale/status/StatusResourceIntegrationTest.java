package no.cantara.tools.visuale.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.helidon.microprofile.server.Server;
import no.cantara.tools.visuale.Main;
import no.cantara.tools.visuale.domain.Health;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.CDI;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;
import java.time.Instant;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;

public class StatusResourceIntegrationTest {
    private static Server server;
    public static ObjectMapper mapper = new ObjectMapper();

    @BeforeAll
    public static void startTheServer() throws Exception {
        server = Main.startServer();
        StatusResource.initializeEnvironment(MOCK_ENVORONMENT, "JUnitTest Env");
        //Thread.sleep(5000);
    }

    @Test()  // for some reason this fails in jenkins as of now
    public void testMockedStatus() throws Exception {

        Client client = ClientBuilder.newClient();

        JsonObject jsonObject = client
                .target(getConnectionString("/status"))
                .request()
                .get(JsonObject.class);
        Assertions.assertTrue(jsonObject.getString("name").length() > 5);

        Health h = new Health().withStatus("OK").withName("test-health").withVersion("0.2.1").withIp("10.3.2.30").withNow(Instant.now().toString());
        Response r;
        r = client
                .target(getConnectionString("/status"))
                .request()
                .put(Entity.json(h));
        Assertions.assertEquals(204, r.getStatus(), "POST status code");

        r = client
                .target(getConnectionString("/health"))
                .request()
                .get();
        Assertions.assertEquals(200, r.getStatus(), "GET health status code");
    }

    @AfterAll
    public static void destroyClass() {
        CDI<Object> current = CDI.current();
        ((SeContainer) current).close();
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + path;
    }
}


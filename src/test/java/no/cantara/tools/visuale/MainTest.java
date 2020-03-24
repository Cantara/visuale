package no.cantara.tools.visuale;

import io.helidon.microprofile.server.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.enterprise.inject.se.SeContainer;
import javax.enterprise.inject.spi.CDI;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class MainTest {
    private static Server server;

    @BeforeAll
    public static void startTheServer() throws Exception {
        server = Main.startServer();
        //Thread.sleep(5000);
    }

    @Test()  // for some reason this fails in jenkins as of now
    public void testMockedStatus() {

        Client client = ClientBuilder.newClient();

        JsonObject jsonObject = client
                .target(getConnectionString("/status"))
                .request()
                .get(JsonObject.class);
        Assertions.assertTrue(jsonObject.getString("message").length() > 20);


        Response r = client
                .target(getConnectionString("/metrics"))
                .request()
                .get();
        Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");

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

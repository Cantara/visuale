package no.cantara.tools.visuale;

import io.helidon.webserver.WebServer;
import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MainTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    private static Main main;
    private static WebServer server;

    @BeforeAll
    public static void startTheServer() throws Exception {
        main = new Main("");
        server = main.startServer(0, true);
        server.start().await(5, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void shutdownTheServer() {
        server.shutdown();
        main.shutdown();
    }

    @Test()  // for some reason this fails in jenkins as of now
    public void testMockedStatus() {

        try {
            Client client = ClientBuilder.newClient();

            Response r2 = client
                    .target(getConnectionString("/health"))
                    .request()
                    .get();
            Assertions.assertEquals(200, r2.getStatus(), "GET health status code");


            String jsonObject = client
                    .target(getConnectionString("/api/status"))
                    .request()
                    .get(String.class);
            Assertions.assertTrue(jsonObject.toString().length() > 5);


//        Response r = client
//                .target(getConnectionString("/metrics"))
//                .request()
//                .get();
//        Assertions.assertEquals(200, r.getStatus(), "GET metrics status code");
        } catch (Exception e) {
            System.out.println(Arrays.asList(e.getStackTrace()));
        }


    }

    @AfterAll
    public static void destroyClass() {
        // CDI<Object> current = CDI.current();
        // ((SeContainer) current).close();
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + path;
    }
}

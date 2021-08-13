package no.cantara.tools.visuale.status;

import io.helidon.webserver.WebServer;
import no.cantara.config.ApplicationProperties;
import no.cantara.config.testsupport.ApplicationPropertiesTestHelper;
import no.cantara.tools.visuale.Main;
import no.cantara.tools.visuale.domain.Environment;
import no.cantara.tools.visuale.domain.Health;
import no.cantara.tools.visuale.domain.Node;
import no.cantara.tools.visuale.domain.Service;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static no.cantara.tools.visuale.utils.MockEnvironment.MOCK_ENVORONMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StatusResourceIntegrationTest {

    static {
        ApplicationPropertiesTestHelper.enableMutableSingleton();
        ApplicationProperties.builder().testDefaults().buildAndSetStaticSingleton();
    }

    private static Main main;
    private static WebServer server;
    private static String contextPath;

    @BeforeAll
    public static void startTheServer() throws Exception {
        main = new Main("");
        contextPath = Main.getConfiguredContextPath();
        server = main.startServer(0, contextPath, false);
        server.start().await(5, TimeUnit.SECONDS);
    }

    @AfterAll
    public static void shutdownTheServer() {
        server.shutdown();
        main.shutdown();
    }

    @Test()
    public void testMockedServer() {
        StatusService statusService = main.getStatusResource().getStatusService();
        statusService.queueFullEnvironment(MOCK_ENVORONMENT, "JUnitTest Env");

        try {
            Client client = ClientBuilder.newClient();

            Response jsonObject = client
                    .target(getConnectionString("/status"))
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get();
            assertEquals(200, jsonObject.getStatus(), "GET health status code");
            assertTrue(jsonObject.getEntity().toString().length() > 5);

            //  Response r = client
            //                .target(uri)
            //                .path("/booking/create")
            //                .request()
            //                .post(Entity.entity(updatedRequest, MediaType.APPLICATION_JSON_TYPE));

            Health h = new Health().withStatus("OK").withName("test-health").withVersion("0.2.1").withIp("10.3.2.30").withNow(Instant.now().toString());
            Response r = client
                    .target(getConnectionString("/api/status/myenv/myservice/mynode?service_tag=mytag&service_type=ACS"))
                    .request()
                    .put(Entity.json(h));
            assertEquals(204, r.getStatus(), "POST status code");

            r = client
                    .target(getConnectionString("/health"))
                    .request()
                    .get();
            assertEquals(200, r.getStatus(), "GET health status code");
        } catch (Exception e) {
            System.out.println(Arrays.asList(e.getStackTrace()));
        }
    }

    @Test()
    public void testNotAllThreeInstancesShowingProblemUsingEntraOsPersonregisterDataExample() throws IOException {

        StatusService statusService = main.getStatusResource().getStatusService();

        statusService.queueFullEnvironment("{}", "EntraOS-DEVTEST");
        statusService.waitForEvents(5, TimeUnit.SECONDS);

        String personregister1Json = readResourceAsString("entraos-personregister-samples/status-personregister-node-1.json");
        String personregister2Json = readResourceAsString("entraos-personregister-samples/status-personregister-node-2.json");
        String personregister3Json = readResourceAsString("entraos-personregister-samples/status-personregister-node-3.json");

        Client client = ClientBuilder.newClient();

        {
            Response jsonObject = client
                    .target(getConnectionString("/status"))
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get();
            assertEquals(200, jsonObject.getStatus(), "GET health status code");

            String json = jsonObject.readEntity(String.class);
            assertTrue(json.length() > 5);
            System.out.printf("JSON BEFORE: %s%n", json);
        }

        {
            Response jsonObject = client
                    .target(getConnectionString("/status/EntraOS-DEVTEST/EntraOS%20PersonRegister%20API/personregister-1"))
                    .queryParam("service_tag", "EntraOS")
                    .queryParam("service_type", "A2A")
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .put(Entity.entity(personregister1Json, MediaType.APPLICATION_JSON_TYPE));
            assertEquals(204, jsonObject.getStatus(), "PUT health status code");
        }

        {
            Response jsonObject = client
                    .target(getConnectionString("/status/EntraOS-DEVTEST/EntraOS%20PersonRegister%20API/personregister-2"))
                    .queryParam("service_tag", "EntraOS")
                    .queryParam("service_type", "A2A")
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .put(Entity.entity(personregister2Json, MediaType.APPLICATION_JSON_TYPE));
            assertEquals(204, jsonObject.getStatus(), "PUT health status code");
        }

        {
            Response jsonObject = client
                    .target(getConnectionString("/status/EntraOS-DEVTEST/EntraOS%20PersonRegister%20API/personregister-3"))
                    .queryParam("service_tag", "EntraOS")
                    .queryParam("service_type", "A2A")
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .put(Entity.entity(personregister3Json, MediaType.APPLICATION_JSON_TYPE));
            assertEquals(204, jsonObject.getStatus(), "PUT health status code");
        }

        statusService.waitForEvents(5, TimeUnit.SECONDS);

        {
            Response jsonObject = client
                    .target(getConnectionString("/status"))
                    .request()
                    .accept(MediaType.APPLICATION_JSON_TYPE)
                    .get();
            assertEquals(200, jsonObject.getStatus(), "GET health status code");
            String json = jsonObject.readEntity(String.class);
            assertTrue(json.length() > 5);
            System.out.printf("JSON AFTER: %s%n", json);

            Environment environment = StatusService.mapper.readValue(json, Environment.class);
            for (Service service : environment.getServices()) {
                Set<String> nodeNames = new LinkedHashSet<>();
                for (Node node : service.getNodes()) {
                    nodeNames.add(node.getName());
                }
                assertEquals(3, nodeNames.size());
                assertTrue(nodeNames.contains("personregister-1"));
                assertTrue(nodeNames.contains("personregister-2"));
                assertTrue(nodeNames.contains("personregister-3"));
            }
        }
    }

    @Test()
    public void thatNodeWithMisreportingIpIsRestoredAfterHealthIsOkAgain() throws IOException {

        StatusService statusService = main.getStatusResource().getStatusService();

        statusService.queueFullEnvironment("{}", "EntraOS-DEVTEST");
        statusService.waitForEvents(5, TimeUnit.SECONDS);

        String okBeforeJson = readResourceAsString("entrasso-lwa-samples/status-entrasso-lwa-1-ok-before.json");
        String misbehavingJson = readResourceAsString("entrasso-lwa-samples/status-entrasso-lwa-1-misbehaving.json");
        String okAfterJson = readResourceAsString("entrasso-lwa-samples/status-entrasso-lwa-1-ok-after.json");

        Client client = ClientBuilder.newClient();

        putHealth(okBeforeJson, client, "/status/prod/LWA/lwa-node01", "EntraSSO", "H2A");
        statusService.waitForEvents(5, TimeUnit.SECONDS);
        verifyStatus(client);
        putHealth(misbehavingJson, client, "/status/prod/LWA/lwa-node01", "EntraSSO", "H2A");
        statusService.waitForEvents(5, TimeUnit.SECONDS);
        verifyStatus(client);
        putHealth(okAfterJson, client, "/status/prod/LWA/lwa-node01", "EntraSSO", "H2A");
        statusService.waitForEvents(5, TimeUnit.SECONDS);
        String json = verifyStatus(client);
        System.out.printf("JSON AFTER: %s%n", json);
    }

    private void putHealth(String healthJson, Client client, String path, String serviceTag, String serviceType) {
        Response jsonObject = client
                .target(getConnectionString(path))
                .queryParam("service_tag", serviceTag)
                .queryParam("service_type", serviceType)
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.entity(healthJson, MediaType.APPLICATION_JSON_TYPE));
        assertEquals(204, jsonObject.getStatus(), "PUT health status code");
    }

    private String verifyStatus(Client client) throws com.fasterxml.jackson.core.JsonProcessingException {
        Response jsonObject = client
                .target(getConnectionString("/status"))
                .request()
                .accept(MediaType.APPLICATION_JSON_TYPE)
                .get();
        assertEquals(200, jsonObject.getStatus(), "GET health status code");
        String json = jsonObject.readEntity(String.class);
        assertTrue(json.length() > 5);

        Environment environment = StatusService.mapper.readValue(json, Environment.class);
        Set<Service> services = environment.getServices();
        assertEquals(1, services.size());
        Service service = services.iterator().next();
        assertEquals("LWA", service.getName());
        Set<Node> nodes = service.getNodes();
        assertEquals(1, nodes.size());
        Node node = nodes.iterator().next();
        assertTrue(node.getName().equals("lwa-node01"));
        return json;
    }

    private String readResourceAsString(String path) throws IOException {
        try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(path)) {
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        }
    }

    private String getConnectionString(String path) {
        return "http://localhost:" + server.port() + contextPath + path;
    }
}


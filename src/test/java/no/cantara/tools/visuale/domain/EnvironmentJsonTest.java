package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class EnvironmentJsonTest {


    public static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testEnvironmentJson() throws Exception {
        Health h = new Health().withNow(Instant.now().toString()).withVersion("23.43");
        Node n = new Node().withHealth(h).withIp("10.34.43.67");
        n.addHealth(h);
        Health h2 = new Health().withNow(Instant.now().toString()).withVersion("1.23");
        Node n2 = new Node().withHealth(h2).withIp("77.34.43.67");
        ;
        n.addHealth(h);

        Set<Node> nodeSet = new HashSet<>();
        nodeSet.add(n);
        nodeSet.add(n2);
        Service s = new Service().withNodes(nodeSet).withName("MyService");

        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(s);
        Environment e = new Environment().withServices(serviceSet).withName("TestEnvironment");

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(e);
        System.out.println("json:" + json);
    }

    @Test
    public void testDeserialization() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Environment environment = mapper.readValue(getMockStatus, Environment.class);
        System.out.println(environment);
    }

    private String getMockStatus = "{\"name\": \"Quadim-QA\",\n" +
            "    \"services\": [\n" +
            "      {\n" +
            "        \"name\": \"Overlord-Service\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.23\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.24\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.25\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.26\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Service-2\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Service-2\",\n" +
            "        \"nodes\": [\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.27\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"ip\": \"10.45.54.29\",\n" +
            "            \"health\": [\n" +
            "              {\n" +
            "                \"Status\": \"true\",\n" +
            "                \"now\": \"2020-03-24T18:34:35.987Z\",\n" +
            "                \"running since\": \"2020-03-23T09:11:49.070Z\",\n" +
            "                \"version\": \"0.61.34\"\n" +
            "              }\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ]}\n";
}
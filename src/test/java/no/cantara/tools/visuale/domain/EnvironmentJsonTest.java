package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class EnvironmentJsonTest {


    public static ObjectMapper mapper = new ObjectMapper();

    @Test
    public void testEnvironmentJson() throws Exception {
        Health h = new Health();
        Node n = new Node();
        n.setHealthInfo(h);
        Node n2 = new Node();
        n.setHealthInfo(h);

        Service s = new Service();
        Set<Node> nodeSet = new HashSet<>();
        nodeSet.add(n);
        nodeSet.add(n2);
        s.setNodes(nodeSet);

        Environment e = new Environment();
        Set<Service> serviceSet = new HashSet<>();
        serviceSet.add(s);
        e.setServices(serviceSet);

        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(e);
        System.out.println("json:" + json);
    }
}
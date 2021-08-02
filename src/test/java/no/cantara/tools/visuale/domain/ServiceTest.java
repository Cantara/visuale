package no.cantara.tools.visuale.domain;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ServiceTest {

    @Test
    public void thatNodeComparatorWithNonNullsWork() {
        Node node1 = new Node().withName("personregister-1").withIp("172.31.11.25");
        Node node2 = new Node().withName("personregister-2").withIp("172.31.11.15");
        Node node3 = new Node().withName("personregister-3").withIp("172.31.10.209");
        TreeSet<Node> nodeSet = new TreeSet<>(new Service.MyNodeNameComp());
        nodeSet.add(node1);
        nodeSet.add(node2);
        nodeSet.add(node3);
        assertEquals(3, nodeSet.size());
        assertTrue(nodeSet.contains(node1));
        assertTrue(nodeSet.contains(node2));
        assertTrue(nodeSet.contains(node3));
    }

    @Test
    public void thatNodeComparatorWithNullsWork() {
        Node node1 = new Node().withName("personregister-1");
        Node node2 = new Node().withIp("172.31.11.15");
        Node node3 = new Node().withName("personregister-3").withIp("172.31.10.209");
        Node node4 = new Node();
        TreeSet<Node> nodeSet = new TreeSet<>(new Service.MyNodeNameComp());
        nodeSet.add(node1);
        nodeSet.add(node2);
        nodeSet.add(node3);
        nodeSet.add(node4);
        assertEquals(4, nodeSet.size());
        assertTrue(nodeSet.contains(node1));
        assertTrue(nodeSet.contains(node2));
        assertTrue(nodeSet.contains(node3));
        assertTrue(nodeSet.contains(node4));
    }
}

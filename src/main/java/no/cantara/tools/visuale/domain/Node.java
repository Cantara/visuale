package no.cantara.tools.visuale.domain;

public class Node {

    private String nodeId = "";
    private String ipAddresses = "";
    private Health healthInfo;


    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getIpAddresses() {
        return ipAddresses;
    }

    public void setIpAddresses(String ipAddresses) {
        this.ipAddresses = ipAddresses;
    }

    public Health getHealthInfo() {
        return healthInfo;
    }

    public void setHealthInfo(Health healthInfo) {
        this.healthInfo = healthInfo;
    }

    @Override
    public String toString() {
        return "Node{" +
                "nodeId='" + nodeId + '\'' +
                ", ipAddresses='" + ipAddresses + '\'' +
                ", healthInfo=" + healthInfo +
                '}';
    }
}

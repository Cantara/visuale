package no.cantara.tools.visuale.domain;

import java.util.HashSet;
import java.util.Set;

public class Service {

    private String serviceName = "";
    private Set<Node> nodes = new HashSet<>();


    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Set<Node> getNodes() {
        return nodes;
    }

    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceName='" + serviceName + '\'' +
                ", nodes=" + nodes +
                '}';
    }
}

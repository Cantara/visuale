
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

import static no.cantara.tools.visuale.utils.StringUtils.hasValue;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "service_tag",
        "service_type",
        "healthy_nodes",
        "need_codebase_chores",
        "nodes"
})
public class Service {

    @JsonProperty("name")
    private String name;
    @JsonProperty("service_tag")
    private String serviceTag = "";
    @JsonProperty("service_type")
    private ServiceType serviceType = new ServiceType().withServiceCategory(ServiceType.ServiceCategorization.CS);
    @JsonProperty("nodes")
    private Set<Node> nodes = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Service withName(String name) {
        this.name = name;
        return this;
    }


    @JsonProperty("need_codebase_chores")
    public boolean needCodeChores() {
        int secure_nodes = 0;
        for (Node n : nodes) {
            if (n.isSecure()) {
                secure_nodes++;
            }

        }
        return secure_nodes == 0;
    }


    @JsonProperty("healthy_nodes")
    public int getHealthyNodes() {
        int healthy_nodes = 0;
        for (Node n : nodes) {
            if (n.isHealthy()) {
                healthy_nodes++;
            }

        }
        return healthy_nodes;
    }


    @JsonProperty("nodes")
    public Set<Node> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(Set<Node> nodesV) {
        this.nodes = new TreeSet<Node>(new MyNodeNameComp());
        nodes.addAll(nodesV);
    }

    public Service withNodes(Set<Node> nodes) {
        this.nodes = nodes;
        return this;
    }

    public Service withNode(Node node) {
       addNode(node);
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Service withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @JsonProperty("service_tag")
    public String getServiceTag() {
        return serviceTag;
    }

    @JsonProperty("service_tag")
    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
    }

    @JsonProperty("service_type")
    public String getServiceType() {
        return serviceType.getServiceType();
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType.setServiceType(serviceType);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(name, service.name) &&
                Objects.equals(serviceTag, service.serviceTag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, serviceTag);
    }

    @Override
    public String toString() {
        return "Service{" +
                "name='" + name + '\'' +
                "serviceTag='" + serviceTag + '\'' +
                "serviceType='" + serviceType + '\'' +
                ", nodes=" + getNodes() +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    public Service withServiceTag(String serviceTag) {
        if (hasValue(serviceTag)) {
            this.serviceTag = serviceTag;
        }
        return this;
    }

    public Service withServiceType(String serviceType) {
        if (hasValue(serviceType)) {
            this.serviceType.setServiceType(serviceType);
        }
        return this;
    }

    public void addNode(Node addnode) {
        if (this.nodes == null) {
//            this.nodes = new TreeSet<>();
            this.nodes = new TreeSet<Node>(new MyNodeNameComp());
        }
        this.nodes.add(addnode);
    }

    public class MyNodeNameComp implements Comparator<Node> {

        @Override
        public int compare(Node e1, Node e2) {
            if (e1.getName() != null && e2.getName() != null) {
                if (e1.getIp() != null && e2.getIp() != null) {
                    return e1.getIp().compareTo(e2.getIp()) + e1.getName().compareTo(e2.getName());
                }
                return e1.getName().compareTo(e2.getName());
            }
            if (e1.getIp() != null && e2.getIp() != null) {
                if (e1.getName() != null && e2.getName() != null) {
                    return e1.getName().compareTo(e2.getName());
                }
                return e1.getIp().compareTo(e2.getIp());
            }
            return 1;
        }
    }

}

package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "nodes"
})
public class Service {

    @JsonProperty("name")
    private String name;
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
        if (this.nodes == null) {
            this.nodes = new TreeSet<Node>(new MyNodeNameComp());
        }
        this.nodes.add(node);
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


    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("nodes", nodes).append("additionalProperties", additionalProperties).toString();
    }

    public class MyNodeNameComp implements Comparator<Node> {

        @Override
        public int compare(Node e1, Node e2) {
            if (e1.getName() != null && e2.getName() != null) {
                return e1.getName().compareTo(e2.getName());
            }
            if (e1.getIp() != null && e2.getIp() != null) {
                return e1.getIp().compareTo(e2.getIp());
            }
            return 1;
        }
    }

}
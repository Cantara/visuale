
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public void setNodes(Set<Node> nodes) {
        this.nodes = nodes;
    }

    public Service withNodes(Set<Node> nodes) {
        this.nodes = nodes;
        return this;
    }

    public Service withNode(Node node) {
        if (this.nodes == null) {
            this.nodes = new HashSet<>();
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

}
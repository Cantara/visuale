
package no.cantara.tools.visuale.utils.config;

import com.fasterxml.jackson.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "environment_name",
        "nodes"
})
public class ConfEnv {

    @JsonProperty("environment_name")
    private String environmentName;
    @JsonProperty("nodes")
    private List<ConfNode> nodes = new ArrayList<ConfNode>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("environment_name")
    public String getEnvironmentName() {
        return environmentName;
    }

    @JsonProperty("environment_name")
    public void setEnvironmentName(String environmentName) {
        this.environmentName = environmentName;
    }

    @JsonProperty("nodes")
    public List<ConfNode> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(List<ConfNode> nodes) {
        this.nodes = nodes;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
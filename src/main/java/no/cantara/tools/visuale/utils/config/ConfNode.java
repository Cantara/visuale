
package no.cantara.tools.visuale.utils.config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "service_name",
        "node_name",
        "health_url"
})
public class ConfNode {

    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("node_name")
    private String nodeName;
    @JsonProperty("health_url")
    private String healthUrl;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("service_name")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("service_name")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    @JsonProperty("node_name")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("node_name")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    @JsonProperty("health_url")
    public String getHealthUrl() {
        return healthUrl;
    }

    @JsonProperty("health_url")
    public void setHealthUrl(String healthUrl) {
        this.healthUrl = healthUrl;
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
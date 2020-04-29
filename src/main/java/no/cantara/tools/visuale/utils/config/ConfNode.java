
package no.cantara.tools.visuale.utils.config;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "service_name",
        "service_type",
        "service_tag",
        "node_name",
        "health_url"
})
public class ConfNode {

    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("service_tag")
    private String serviceTag;
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

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceTag() {
        return serviceTag;
    }

    public void setServiceTag(String serviceTag) {
        this.serviceTag = serviceTag;
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
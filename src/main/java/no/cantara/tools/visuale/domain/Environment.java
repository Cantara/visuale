
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "services"
})
public class Environment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("services")
    private Set<Service> services = null;
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

    public Environment withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("services")
    public Set<Service> getServices() {
        return services;
    }

    @JsonProperty("services")
    public void setServices(Set<Service> services) {
        this.services = services;
    }

    public Environment withServices(Set<Service> services) {
        this.services = services;
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

    public Environment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("services", services).append("additionalProperties", additionalProperties).toString();
    }

}
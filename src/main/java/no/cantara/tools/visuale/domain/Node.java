
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ip",
        "health"
})
public class Node {

    @JsonProperty("ip")
    private String ip;
    @JsonProperty("health")
    private Set<Health> health = new HashSet<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Node withIp(String ip) {
        this.ip = ip;
        return this;
    }

    @JsonProperty("health")
    public Set<Health> getHealth() {
        return health;
    }

    @JsonProperty("health")
    public void setHealth(Set<Health> health) {
        this.health = health;
    }

    public void addHealth(Health health) {
        this.health.add(health);
    }

    public Node withHealth(Health health) {
        addHealth(health);
        return this;
    }

    public Node withHealth(Set<Health> health) {
        this.health = health;
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

    public Node withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("ip", ip).append("health", health).append("additionalProperties", additionalProperties).toString();
    }

}
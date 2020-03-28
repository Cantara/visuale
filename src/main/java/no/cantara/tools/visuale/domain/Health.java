
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Status",
        "now",
        "running since",
        "version"
})
public class Health {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("now")
    private String now;
    @JsonProperty("running since")
    private String runningSince;
    @JsonProperty("version")
    private String version;
    @JsonProperty("ip")
    private String ip;

    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Status")
    public String getStatus() {
        return status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        this.status = status;
    }

    public Health withStatus(String status) {
        this.status = status;
        return this;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = ip;
    }

    public Health withIp(String ip) {
        this.ip = ip;
        return this;
    }

    @JsonProperty("now")
    public String getNow() {
        return now;
    }

    @JsonProperty("now")
    public void setNow(String now) {
        this.now = now;
    }

    public Health withNow(String now) {
        this.now = now;
        return this;
    }

    @JsonProperty("running since")
    public String getRunningSince() {
        return runningSince;
    }

    @JsonProperty("running since")
    public void setRunningSince(String runningSince) {
        this.runningSince = runningSince;
    }

    public Health withRunningSince(String runningSince) {
        this.runningSince = runningSince;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Health withVersion(String version) {
        this.version = version;
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

    public Health withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("status", status).append("now", now).append("runningSince", runningSince).append("version", version).append("additionalProperties", additionalProperties).toString();
    }

}
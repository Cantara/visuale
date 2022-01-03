
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import static no.cantara.tools.visuale.domain.HealthMapper.extractIpv4Address;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "Status",
        "name",
        "version",
        "probed_from",
        "now",
        "running since",
        "ip",
        "original_health",
        "additionalProperties"
})
public class Health {

    @JsonProperty("Status")
    private String status;
    @JsonProperty("name")
    private String name;
    @JsonProperty("probed_from")
    private String probedFrom = "Agent";
    @JsonProperty("now")
    private String now;

    private String receivedNow;
    @JsonProperty("running since")
    private String runningSince;
    @JsonProperty("version")
    private String version;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("original_health")
    private String originalHealth;

    @JsonProperty("service_name")
    private String serviceName;
    @JsonProperty("service_tag")
    private String serviceTag;
    @JsonProperty("service_type")
    private String serviceType;

    //@JsonIgnore
    @JsonProperty("additionalProperties")
    private Map<String, String> additionalProperties = new HashMap<String, String>();

    @JsonIgnore
    public String getLookupKey() {
        String name = getName();
        String ip = getIp();
        String version = getVersion();
        if (name == null) {
            name = "";
        }
        name = name.replace(" ", "");
        if (ip == null) {
            ip = "";
        }
        if (version == null) {
            version = "";
        }
        String key = name.trim() + "+" + version + ":" + ip.trim() + "-" + runningSince;
        return key;
    }

    @JsonProperty("Status")
    public String getStatus() {
        if (status == null || status.length() < 1) {
            return "N/A";
        }
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

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {

        if (name == null) {
            return;
        }
        this.name = name.trim();
    }

    @JsonProperty("probed_from")
    public String getProbedFrom() {
        return probedFrom;
    }

    @JsonProperty("probed_from")
    public void setProbedFrom(String probedFrom) {
        this.probedFrom = probedFrom;
    }

    public Health withName(String name) {
        if (name == null) {
            return this;
        }
        this.name = name.trim();
        return this;
    }

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = extractIpv4Address(ip);
    }

    public Health withIp(String ip) {
        this.ip = extractIpv4Address(ip);
        return this;
    }

    @JsonProperty("now")
    public String getNow() {
        return now;
    }

    @JsonProperty("now")
    public void setNow(String now) {
        if (now == null || now.length() < 10) {
            now = Instant.now().toString();
        }
        this.now = now;
    }

    public Health withNow(String now) {
        if (now == null || now.length() < 10) {
            now = Instant.now().toString();
        }
        this.now = now;
        return this;
    }

    public String getReceivedNow() {
        return receivedNow;
    }

    public void setReceivedNow(String receivedNow) {
        this.receivedNow = receivedNow;
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

    @JsonProperty("original_health")
    public String getOriginalHealth() {
        return originalHealth;
    }

    @JsonProperty("original_health")
    public void setOriginalHealth(String originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Health withOriginalHealth(String origHealth) {
        this.originalHealth = origHealth;
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

    @JsonProperty("service_name")
    public String getServiceName() {
        return serviceName;
    }

    @JsonProperty("service_name")
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
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
        return serviceType;
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public boolean isEmpty() {
        if (toString().length() > 100) {
            return false;
        }
        return true;
    }

    @JsonAnyGetter
    public Map<String, String> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
    }

    public Health withAdditionalProperty(String name, String value) {
        this.additionalProperties.put(name, value);
        return this;
    }


    public Health withAdditionalProperties(Map<String, String> additionalProperties1) {
        this.additionalProperties.putAll(additionalProperties1);
        return this;
    }


    public Health() {

    }

    public Health(String status, String name, String now, String receivedNow, String runningSince, String version, String ip) {
        this.status = status;
        this.name = name;
        this.now = now;
        this.receivedNow = receivedNow;
        this.runningSince = runningSince;
        this.version = version;
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Health{" +
                "status='" + status + '\'' +
                ", name='" + name + '\'' +
                ", now='" + now + '\'' +
                ", receivedNow='" + receivedNow + '\'' +
                ", runningSince='" + runningSince + '\'' +
                ", version='" + version + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
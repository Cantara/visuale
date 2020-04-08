
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import static no.cantara.tools.visuale.domain.HealthMapper.extractIpv4Address;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "ip",
        "last_seen",
        "is_healthy",
        "is_unstable",
        "is_secure",
        "health"
})
public class Node {
    public static final Logger logger = LoggerFactory.getLogger(Node.class);

    @JsonProperty("name")
    private String name;
    @JsonProperty("ip")
    private String ip;
    @JsonProperty("health")
    private Set<Health> health = new CopyOnWriteArraySet<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    @JsonIgnore
    public String getLookupKey() {
        String key = getName().trim() + ":" + getIp().trim();
        return key;
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Node withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("ip")
    public String getIp() {
        if (ip == null || ip.length() < 1) {
            return "10.10.10.10";
        }
        return ip;
    }

    @JsonProperty("ip")
    public void setIp(String ip) {
        this.ip = extractIpv4Address(ip);
    }

    public Node withIp(String ip) {
        this.ip = extractIpv4Address(ip);
        return this;
    }

    @JsonProperty("last_seen")
    public String getlastSeen() {
        return getLastSeen().toString();
    }


    @JsonIgnore
    private Instant getLastSeen() {
        Instant lastSeenInstant = Instant.now().minus(30, ChronoUnit.DAYS);
        for (Health h : getHealth()) {
            try {
                // 2020-03-24T18:34:35.987Z
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                Instant reqInstant = date.toInstant();
                if (reqInstant.isAfter(lastSeenInstant)) {
                    lastSeenInstant = reqInstant;
                }
            } catch (Exception e) {
                logger.error("Exception trying to parse now from health", e);
            }

        }
        return lastSeenInstant;
    }

    @JsonProperty("is_healthy")
    public boolean isHealthy() {
        Instant lastSeenInstant = getLastSeen();
        Instant five_minutes_ago = Instant.now().minus(5, ChronoUnit.MINUTES);
        if (lastSeenInstant.isBefore(five_minutes_ago)) {
            return false;
        }
        return true;
    }

    @JsonProperty("is_unstable")
    public boolean isUnstable() {
        return false;
//        Instant lastSeenInstant = getLastSeen();
//        Instant ninety_seconds_ago = Instant.now().minus(2700, ChronoUnit.SECONDS);
//        if (lastSeenInstant.isAfter(ninety_seconds_ago)) {
//            return true;
//        }
//        return false;
    }

    @JsonProperty("is_secure")
    public boolean isSecure() {
        boolean isSecure = false;
        Instant uptimeInstant = Instant.MIN;
        for (Health h : getHealth()) {
            try {
                // 2020-03-24T18:34:35.987Z
                OffsetDateTime date = OffsetDateTime.parse(h.getRunningSince());
                Instant reqInstant = date.toInstant();
                if (reqInstant.isAfter(uptimeInstant)) {
                    uptimeInstant = reqInstant;
                }
            } catch (Exception e) {
                logger.error("Exception trying to parse running since from health", e);
                isSecure = false;
            }
        }
        Instant seven_days_ago = Instant.now().minus(7, ChronoUnit.DAYS);
        if (uptimeInstant.getEpochSecond() > seven_days_ago.getEpochSecond()) {
            isSecure = true;
        }
        return isSecure;
    }


    @JsonProperty("health")
    public Set<Health> getHealth() {
        return health;
    }

    @JsonProperty("health")
    public void setHealth(Set<Health> health) {
        this.health = health;
    }

    public void addHealth(Health healthValue) {
        if (health == null || health.size() > 5) {  // simple housecleaning
            this.health = new CopyOnWriteArraySet<>();
        }
        if (healthValue.getIp() == null || healthValue.getIp().length() < 5) {
            healthValue.setIp(getIp());
        }
        if (getName() == null || getName().length() < 2 && healthValue.getName() != null && healthValue.getName().length() > 2) {
            setName(healthValue.getName());
        }

        this.health.add(healthValue);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(name, node.name) &&
                Objects.equals(ip, node.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ip);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", health=" + health +
                '}';
    }
}
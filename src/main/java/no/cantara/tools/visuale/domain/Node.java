
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
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
        "version",
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
    @JsonProperty("version")
    private String version;
    @JsonProperty("health")
    private Set<Health> health = new CopyOnWriteArraySet<>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    @JsonIgnore
    private int calculatedDrift = 0;
    @JsonIgnore
    private String calculatedRunningSince;


    @JsonIgnore
    public String getLookupKey() {
        String key = getName().replace(" ", "") + "+" + getVersion() + ":" + getIp();
        return key;
    }


    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name.trim();
    }

    public Node withName(String name) {
        this.name = name.trim();
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

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Node withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("last_seen")
    public String getlastSeen() {
        return getLastSeen().toString();
    }


    @JsonIgnore
    private int getCalculatedDrift() {
        return calculatedDrift;
    }

    @JsonIgnore
    private void calculatedDrift() {
        if (getHealth() == null || getHealth().size() == 0) {
            return;
        }
        try {
            int measurements = getHealth().size();
            long total = 0;
            for (Health h : getHealth()) {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                Instant reqInstant = date.toInstant();
                OffsetDateTime recdate = OffsetDateTime.parse(h.getReceivedNow());
                Instant recInstant = recdate.toInstant();
                Duration between = Duration.between(recInstant, reqInstant);

                long seconds = between.getSeconds();
                total += seconds;
            }
            double average = total / measurements;
            calculatedDrift = (int) average;
        } catch (Exception e) {
            logger.warn("Unable to parse dates in Health", e);
        }
    }

    @JsonIgnore
    private Instant getLastSeen() {
        Instant lastSeenInstant = Instant.now().minus(30, ChronoUnit.DAYS);
        try {
            Health h = getLatestHealth();
            if (h != null) {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                return date.toInstant();
            }
        } catch (Exception e) {
            logger.error("Exception trying to parse now from health", e);
        }
        return lastSeenInstant;
    }

    @JsonProperty("is_healthy")
    public boolean isHealthy() {
        try {
            Health h = getLatestHealth();
            if (h != null) {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                Instant lastSeenInstant = date.toInstant();
                Instant eight_minutes_ago = Instant.now().minus(8, ChronoUnit.MINUTES)
                        .plus(getCalculatedDrift(), ChronoUnit.SECONDS);
                if (lastSeenInstant.isBefore(eight_minutes_ago)) {
                    return false;
                }
                if (h != null && h.getStatus() != null && h.getStatus().equalsIgnoreCase("OK")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            logger.warn("Unable to parse/calculate lastSeen:", e);
        }
        return false;
    }

    @JsonProperty("is_unstable")
    public boolean isUnstable() {
        Health h = getLatestHealth();
        if (h == null) {
            return true;
        }
        try {
            OffsetDateTime date = OffsetDateTime.parse(h.getNow());
            Instant uptimeInstant = date.toInstant();
            Instant three_minutes_ago = Instant.now().minus(3, ChronoUnit.MINUTES).plus(getCalculatedDrift(), ChronoUnit.SECONDS);
            ;
            if (uptimeInstant.getEpochSecond() > three_minutes_ago.getEpochSecond()) {
                return false;
            }
        } catch (Exception e) {
            logger.error("Exception trying to parse now from health", e);
        }

        return true;
    }

    @JsonProperty("is_secure")
    public boolean isSecure() {
        boolean isSecure = false;
        Instant uptimeInstant = Instant.MIN;
        Health h = getLatestHealth();
        if (h != null) {
            try {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                uptimeInstant = date.toInstant();
            } catch (Exception e) {
                logger.error("Exception trying to parse now from health", e);
            }
            Instant seven_days_ago = Instant.now().minus(7, ChronoUnit.DAYS);
            if (uptimeInstant.getEpochSecond() > seven_days_ago.getEpochSecond()) {
                isSecure = true;
            }
            return isSecure;
        }
        return false;
    }


    @JsonProperty("health")
    public Set<Health> getHealth() {
        return health;
    }

    public Health getLatestHealth() {
        Health returnHealth = null;
        Instant oldInstant = Instant.now().minus(8, ChronoUnit.DAYS);
        try {
            for (Health h : getHealth()) {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                Instant reqInstant = date.toInstant();
                if (reqInstant.isAfter(oldInstant)) {
                    oldInstant = reqInstant;
                    returnHealth = h;
                }
            }
        } catch (Exception e) {
            logger.warn("Unable to parse dates in Health", e);
        }
        return returnHealth;
    }

    public Health getEarliestHealth() {
        Health returnHealth = null;
        Instant oldInstant = Instant.now().minus(8, ChronoUnit.DAYS);
        try {
            for (Health h : getHealth()) {
                OffsetDateTime date = OffsetDateTime.parse(h.getNow());
                Instant reqInstant = date.toInstant();
                if (reqInstant.isBefore(oldInstant)) {
                    oldInstant = reqInstant;
                    returnHealth = h;
                }
            }
        } catch (Exception e) {
            logger.warn("Unable to parse dates in Health", e);
        }
        return returnHealth;
    }

    @JsonProperty("health")
    public void setHealth(Set<Health> health) {
        this.health = health;
    }

    public void addHealth(Health healthValue) {
        if (health == null || health.size() > 5) {  // simple housecleaning
            calculatedDrift();
            this.health = new CopyOnWriteArraySet<>();
        }
        if (healthValue.getIp() == null || healthValue.getIp().length() < 5) {
            healthValue.setIp(getIp());
        }
        if (getName() == null || getName().length() < 2) {
            if (healthValue.getName() != null && healthValue.getName().length() > 2) {
                setName(healthValue.getName());
            }
        }
        if (calculatedRunningSince == null) {
            Instant nowInstant = Instant.now();
            try {
                OffsetDateTime date = OffsetDateTime.parse(healthValue.getNow());
                Instant reqInstant = date.toInstant();

                // We only correlate now in health if time is in the future
                if (reqInstant.isAfter(nowInstant)) {
                    healthValue.setNow(nowInstant.toString());
                    calculatedRunningSince = nowInstant.toString();
                }
            } catch (Exception e) {
                healthValue.setNow(nowInstant.toString());
                calculatedRunningSince = nowInstant.toString();
            }
        } else {
            healthValue.setNow(calculatedRunningSince);
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
                Objects.equals(ip, node.ip) &&
                Objects.equals(version, node.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ip, version);
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", version='" + version + '\'' +
                ", health=" + health +
                '}';
    }
}
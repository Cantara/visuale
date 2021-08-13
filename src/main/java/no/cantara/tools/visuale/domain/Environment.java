
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "services"
})
public class Environment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("services")
    private Set<Service> services = new CopyOnWriteArraySet<Service>(); // new HashSet<>(); //new TreeSet<Service>(new ServiceComparator());
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

    public void addService(Service service) {
        if (this.services == null) {
            this.services = new CopyOnWriteArraySet<>(); // new HashSet<>();
//            this.services = new TreeSet<Service>(new MyServiceNameComp());
        }
        this.services.add(service);
    }

    public Environment withServices(Set<Service> services) {
        this.services = new CopyOnWriteArraySet<>(); // new TreeSet<Service>(new MyServiceNameComp());
        services.addAll(services);
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
        return "Environment{" +
                "name='" + name + '\'' +
                ", services=" + getServices() +
                ", additionalProperties=" + additionalProperties +
                '}';
    }

    public static class ServiceComparator implements Comparator<Service> {
        @Override
        public int compare(Service s1, Service s2) {
            if (s1 == s2) {
                return 0;
            }
            if (!Objects.equals(s1.getName(), s2.getName())) {
                if (s1.getName() == null) {
                    return -1;
                }
                if (s2.getName() == null) {
                    return 1;
                }
                return s1.getName().compareTo(s2.getName());
            }
            if (!Objects.equals(s1.getServiceTag(), s2.getServiceTag())) {
                if (s1.getServiceTag() == null) {
                    return -1;
                }
                if (s2.getServiceTag() == null) {
                    return 1;
                }
                return s1.getServiceTag().compareTo(s2.getServiceTag());
            }
            return 0;
        }
    }
}
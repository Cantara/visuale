
package no.cantara.tools.visuale.domain;

import com.fasterxml.jackson.annotation.*;

import java.util.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "services"
})
public class Environment {

    @JsonProperty("name")
    private String name;
    @JsonProperty("services")
    private Set<Service> services = new HashSet<>(); //new TreeSet<Service>(new MyServiceNameComp());
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
            this.services = new HashSet<>();
//            this.services = new TreeSet<Service>(new MyServiceNameComp());
        }
        for (Service existingservice : services) {
            if (existingservice.getName().equalsIgnoreCase(service.getName())) {
                for (Node node : service.getNodes()) {
                    existingservice.addNode(node);
                }
            }
        }
        this.services.add(service);
    }

    public Environment withServices(Set<Service> services) {
        this.services = new TreeSet<Service>(new MyServiceNameComp());
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

    public class MyServiceNameComp implements Comparator<Service> {

        @Override
        public int compare(Service e1, Service e2) {
            if (e1.getName() != null && e2.getName() != null) {
                return e1.getName().compareTo(e2.getName());
            }
            return 1;
        }
    }
}
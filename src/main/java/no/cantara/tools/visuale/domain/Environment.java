package no.cantara.tools.visuale.domain;

import java.util.HashSet;
import java.util.Set;

public class Environment {

    private String serviceName = "";
    private Set<Service> services = new HashSet<>();

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Set<Service> getServices() {
        return services;
    }

    public void setServices(Set<Service> services) {
        this.services = services;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "serviceName='" + serviceName + '\'' +
                ", services=" + services +
                '}';
    }
}

package no.cantara.tools.visuale.status;

import no.cantara.tools.visuale.domain.Health;

public class EnvironmentUpdateHolder {
    String envName;
    String serviceName;
    String serviceTag;
    String serviceType;
    String nodeName;
    Health health;

    public EnvironmentUpdateHolder(String envName, String serviceName, String serviceTag, String serviceType, String nodeName, Health health) {
        this.envName = envName;
        this.serviceName = serviceName;
        this.serviceTag = serviceTag;
        this.serviceType = serviceType;
        this.nodeName = nodeName;
        this.health = health;
    }

}

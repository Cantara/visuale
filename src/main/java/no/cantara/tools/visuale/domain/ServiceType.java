package no.cantara.tools.visuale.domain;

public class ServiceType {

    private String serviceType;

    public void setServiceType(String serviceType) {
        for (ServiceCategorization type : ServiceCategorization.values()) {
            if (type.name().equalsIgnoreCase(serviceType)) {
                this.serviceType = type.name();
                return;
            }
        }
        this.serviceType = serviceType;
    }

    public ServiceType withServiceCategory(ServiceCategorization cs) {
        this.serviceType = cs.name();
        return this;
    }


    public enum ServiceCategorization {
        CS, ACS, A2A, H2A
    }

    public String getServiceType() {
        return serviceType;
    }


}

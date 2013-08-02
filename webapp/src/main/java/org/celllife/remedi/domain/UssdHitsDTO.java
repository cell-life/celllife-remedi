package org.celllife.remedi.domain;

public class UssdHitsDTO {

    private int serviceId;

    private String service;

    private long serviceHits;

    private long smsHits;

    protected UssdHitsDTO() {

    }

    public UssdHitsDTO(int serviceId, String service, long serviceHits, long smsHits) {
        this.serviceId = serviceId;
        this.service = service;
        this.serviceHits = serviceHits;
        this.smsHits = smsHits;
    }

    public long getServiceHits() {
        return serviceHits;
    }

    public void setServiceHits(int serviceHits) {
        this.serviceHits = serviceHits;
    }

    public long getSmsHits() {
        return smsHits;
    }

    public void setSmsHits(int smsHits) {
        this.smsHits = smsHits;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

}
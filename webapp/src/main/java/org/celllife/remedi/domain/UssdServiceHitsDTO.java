package org.celllife.remedi.domain;

public class UssdServiceHitsDTO {

    private int serviceId;

    private String serviceTitle;

    private long serviceHits;

    private long smsHits;

    private int themeId;

    protected UssdServiceHitsDTO() {

    }

    public UssdServiceHitsDTO(int serviceId, String service, long serviceHits, long smsHits, int themeId) {
        this.serviceId = serviceId;
        this.serviceTitle = service;
        this.serviceHits = serviceHits;
        this.smsHits = smsHits;
        this.themeId = themeId;
    }

    public long getServiceHits() {
        return serviceHits;
    }

    public void setServiceHits(long serviceHits) {
        this.serviceHits = serviceHits;
    }

    public long getSmsHits() {
        return smsHits;
    }

    public void setSmsHits(long smsHits) {
        this.smsHits = smsHits;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

}
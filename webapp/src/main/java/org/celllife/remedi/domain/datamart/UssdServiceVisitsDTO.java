package org.celllife.remedi.domain.datamart;

public class UssdServiceVisitsDTO {

    private String serviceId;

    private String serviceTitle;

    private long serviceVisits;

    private long smses;

    private String themeId;

    protected UssdServiceVisitsDTO() {

    }

    public UssdServiceVisitsDTO(String serviceId, String service, long serviceVisits, long smses, String themeId) {
        this.serviceId = serviceId;
        this.serviceTitle = service;
        this.serviceVisits = serviceVisits;
        this.smses = smses;
        this.themeId = themeId;
    }

    public long getServiceVisits() {
        return serviceVisits;
    }

    public void setServiceVisits(long serviceVisits) {
        this.serviceVisits = serviceVisits;
    }

    public long getSmses() {
        return smses;
    }

    public void setSmses(long smses) {
        this.smses = smses;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

}
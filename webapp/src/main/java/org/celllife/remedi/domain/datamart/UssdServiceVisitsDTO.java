package org.celllife.remedi.domain.datamart;

public class UssdServiceVisitsDTO {

    private int serviceId;

    private String serviceTitle;

    private long serviceVisits;

    private long smses;

    private int themeId;

    protected UssdServiceVisitsDTO() {

    }

    public UssdServiceVisitsDTO(int serviceId, String service, long serviceVisits, long smses, int themeId) {
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
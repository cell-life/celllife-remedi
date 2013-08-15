package org.celllife.remedi.domain.datamart;

public class UssdThemeVisitsDTO {

    private String themeId;

    private String themeTitle;

    private long themeVisits;

    protected UssdThemeVisitsDTO() {

    }

    public UssdThemeVisitsDTO(String themeId, String themeTitle, long themeVisits) {
        this.themeId = themeId;
        this.themeTitle = themeTitle;
        this.themeVisits = themeVisits;
    }

    public long getThemeVisits() {
        return themeVisits;
    }

    public void setThemeVisits(long themeVisits) {
        this.themeVisits = themeVisits;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

}
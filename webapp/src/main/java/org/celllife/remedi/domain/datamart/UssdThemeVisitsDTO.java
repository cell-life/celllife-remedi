package org.celllife.remedi.domain.datamart;

public class UssdThemeVisitsDTO {

    private int themeId;

    private String themeTitle;

    private long themeVisits;

    protected UssdThemeVisitsDTO() {

    }

    public UssdThemeVisitsDTO(int themeId, String themeTitle, long themeVisits) {
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

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }

}
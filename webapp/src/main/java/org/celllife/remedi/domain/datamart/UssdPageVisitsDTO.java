package org.celllife.remedi.domain.datamart;

public class UssdPageVisitsDTO {

    private String pageId;

    private String pageTitle;

    private long pageVisits;

    private long smses;

    private boolean isTheme;

    protected UssdPageVisitsDTO() {

    }

    public UssdPageVisitsDTO(String pageId, String pageTitle, long pageVisits, long smses, boolean isTheme) {
        this.pageId = pageId;
        this.pageTitle = pageTitle;
        this.pageVisits = pageVisits;
        this.smses = smses;
        this.isTheme = isTheme;
    }

    public long getPageVisits() {
        return pageVisits;
    }

    public void setPageVisits(long pageVisits) {
        this.pageVisits = pageVisits;
    }

    public long getSmses() {
        return smses;
    }

    public void setSmses(long smses) {
        this.smses = smses;
    }

    public String getPageId() {
        return pageId;
    }

    public void setPageId(String pageId) {
        this.pageId = pageId;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public boolean isTheme() {
        return isTheme;
    }

    public void setTheme(boolean theme) {
        isTheme = theme;
    }

}
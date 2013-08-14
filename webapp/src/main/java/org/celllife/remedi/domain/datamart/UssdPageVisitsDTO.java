package org.celllife.remedi.domain.datamart;

public class UssdPageVisitsDTO {

    private int screenId;

    private String screenTitle;

    private long screenVisits;

    private long smsHits;

    private boolean isTheme;

    protected UssdPageVisitsDTO() {

    }

    public UssdPageVisitsDTO(int screenId, String screenTitle, long screenVisits, long smsHits, boolean isTheme) {
        this.screenId = screenId;
        this.screenTitle = screenTitle;
        this.screenVisits = screenVisits;
        this.smsHits = smsHits;
        this.isTheme = isTheme;
    }

    public long getScreenVisits() {
        return screenVisits;
    }

    public void setScreenVisits(long screenVisits) {
        this.screenVisits = screenVisits;
    }

    public long getSmsHits() {
        return smsHits;
    }

    public void setSmsHits(long smsHits) {
        this.smsHits = smsHits;
    }

    public int getScreenId() {
        return screenId;
    }

    public void setScreenId(int screenId) {
        this.screenId = screenId;
    }

    public String getScreenTitle() {
        return screenTitle;
    }

    public void setScreenTitle(String screenTitle) {
        this.screenTitle = screenTitle;
    }

    public boolean isTheme() {
        return isTheme;
    }

    public void setTheme(boolean theme) {
        isTheme = theme;
    }

}
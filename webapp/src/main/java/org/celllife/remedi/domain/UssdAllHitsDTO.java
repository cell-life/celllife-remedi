package org.celllife.remedi.domain;

public class UssdAllHitsDTO {

    private int screenId;

    private String screenTitle;

    private long screenHits;

    private long smsHits;

    private boolean isTheme;

    protected UssdAllHitsDTO() {

    }

    public UssdAllHitsDTO(int screenId, String screenTitle, long screenHits, long smsHits, boolean isTheme) {
        this.screenId = screenId;
        this.screenTitle = screenTitle;
        this.screenHits = screenHits;
        this.smsHits = smsHits;
        this.isTheme = isTheme;
    }

    public long getScreenHits() {
        return screenHits;
    }

    public void setScreenHits(long screenHits) {
        this.screenHits = screenHits;
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
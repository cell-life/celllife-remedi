package org.celllife.remedi.domain;

import java.util.List;

public class UssdThemeHitsDTO {

    private int themeId;

    private String themeTitle;

    private long themeHits;

    //private List<UssdServiceHitsDTO> ussdServiceHitsDTOList;

    protected UssdThemeHitsDTO() {

    }

    public UssdThemeHitsDTO(int themeId, String themeTitle, long themeHits) {
        this.themeId = themeId;
        this.themeTitle = themeTitle;
        this.themeHits = themeHits;
    }

    public long getThemeHits() {
        return themeHits;
    }

    public void setThemeHits(long themeHits) {
        this.themeHits = themeHits;
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

    /*public List<UssdServiceHitsDTO> getUssdServiceHitsDTOList() {
        return ussdServiceHitsDTOList;
    }

    public void setUssdServiceHitsDTOList(List<UssdServiceHitsDTO> ussdServiceHitsDTOList) {
        this.ussdServiceHitsDTOList = ussdServiceHitsDTOList;
    } */

}
package org.celllife.remedi.domain.datamart;

import javax.persistence.*;
import java.util.Date;

/**
 * Created By: Diné Bennett
 * Date: 7/31/13
 * Time: 12:37 PM
 */
@Entity
@Cacheable
public class UssdPageVisit {

    public String getId() {
        return id;
    }

    @Id
    private String id;

    @Basic(optional=false)
    private String ussdSessionId;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional=false)
    private Date date;

    @Basic(optional=false)
    private String msisdn;

    private Integer mnoCode;

    private Integer contentVersion;

    private Integer serviceId;

    private String serviceTitle;

    private Integer smsId;

    @Basic(optional=false)
    private Integer themeId;

    @Basic(optional=false)
    private String themeTitle;

    public UssdPageVisit() {

    }

    public String getUssdSessionId() {
        return ussdSessionId;
    }

    public void setUssdSessionId(String ussdSessionId) {
        this.ussdSessionId = ussdSessionId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public Integer getMnoCode() {
        return mnoCode;
    }

    public void setMnoCode(Integer mnoCode) {
        this.mnoCode = mnoCode;
    }

    public Integer getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(Integer contentVersion) {
        this.contentVersion = contentVersion;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public Integer getSmsId() {
        return smsId;
    }

    public void setSmsId(Integer smsId) {
        this.smsId = smsId;
    }

    public Integer getThemeId() {
        return themeId;
    }

    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceTitle() {
        return serviceTitle;
    }

    public void setServiceTitle(String serviceTitle) {
        this.serviceTitle = serviceTitle;
    }

    public String getThemeTitle() {
        return themeTitle;
    }

    public void setThemeTitle(String themeTitle) {
        this.themeTitle = themeTitle;
    }


}
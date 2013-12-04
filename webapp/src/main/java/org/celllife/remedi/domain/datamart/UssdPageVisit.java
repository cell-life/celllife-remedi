package org.celllife.remedi.domain.datamart;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Entity object containing the USSD Session data specifically flattened for use in reports.
 *
 * The data is extracted from the Entity object Request.
 */
@Entity
@Cacheable
public class UssdPageVisit {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Basic(optional=false)
    private String ussdSessionId;

    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional=false)
    private Date date;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Basic(optional=false)
    private Date endDate;

    @Basic(optional=false)
    private String msisdn;

    private String mnoCode;

    private String contentVersion;

    private String serviceId;

    private String serviceTitle;

    private String smsId;

    @Basic(optional=false)
    private String themeId;

    @Basic(optional=false)
    private String themeTitle;

    public UssdPageVisit() {

    }
    
    public UssdPageVisit(String ussdSessionId, Date startDate, Date endDate, String msisdn, String mnoCode, String contentVersion) {
    	super();
    	setUssdSessionId(ussdSessionId);
    	setStartDate(startDate);
    	setEndDate(endDate);
    	setMsisdn(msisdn);
    	setMnoCode(mnoCode);
    	setContentVersion(contentVersion);
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

    public Date getStartDate() {
        return date;
    }

    public void setStartDate(Date startDate) {
        this.date = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getMnoCode() {
        return mnoCode;
    }

    public void setMnoCode(String mnoCode) {
        this.mnoCode = mnoCode;
    }

    public String getContentVersion() {
        return contentVersion;
    }

    public void setContentVersion(String contentVersion) {
        this.contentVersion = contentVersion;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

	@Override
	public String toString() {
		return "UssdPageVisit [id=" + id + ", ussdSessionId=" + ussdSessionId
				+ ", startDate=" + date + ", endDate=" + endDate + ", msisdn=" + msisdn + ", mnoCode="
				+ mnoCode + ", contentVersion=" + contentVersion
				+ ", serviceId=" + serviceId + ", serviceTitle=" + serviceTitle
				+ ", smsId=" + smsId + ", themeId=" + themeId + ", themeTitle="
				+ themeTitle + "]";
	}
}
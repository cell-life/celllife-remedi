package org.celllife.remedi.domain.ussd;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Service entity for the USSD endpoint. Contains information about which service a user requested information about.
 */
@Entity
public class Service implements Serializable {

	private static final long serialVersionUID = 5524061530856185789L;

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

	private Long serviceId;
    private String serviceTitle;
    private String serviceDescription;
    
    @OneToOne
    @JoinColumn(name="theme")
    private Theme theme;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }  

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		System.out.println("service title="+serviceTitle);
		this.serviceTitle = serviceTitle;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Service [id=" + id + ",serviceId=" + serviceId + ", serviceTitle="
				+ serviceTitle + ", serviceDescription=" + serviceDescription
				+ ", theme=" + theme.getId()
				+ "]";
	}
}

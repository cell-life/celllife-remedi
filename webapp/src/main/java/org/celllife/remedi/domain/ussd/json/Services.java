package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public class Services implements Serializable {

	private static final long serialVersionUID = 7559864238407659532L;

	private String serviceId;
	private String serviceTitle;
	private String serviceDescription;
	
	public Services() {
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceTitle() {
		return serviceTitle;
	}

	public void setServiceTitle(String serviceTitle) {
		this.serviceTitle = serviceTitle;
	}

	public String getServiceDescription() {
		return serviceDescription;
	}

	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}

	@Override
	public String toString() {
		return "Services [serviceId=" + serviceId + ", serviceTitle="
				+ serviceTitle + ", serviceDescription=" + serviceDescription
				+ "]";
	}
}

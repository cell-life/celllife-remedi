package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public class Sms implements Serializable {

	private static final long serialVersionUID = -4349015027930994711L;

	private String serviceId;
	private String smsId;
	private String smsText;
	
	public Sms() {
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

	public String getSmsText() {
		return smsText;
	}

	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

	@Override
	public String toString() {
		return "Sms [serviceId=" + serviceId + ", smsId=" + smsId
				+ ", smsText=" + smsText + "]";
	}
}

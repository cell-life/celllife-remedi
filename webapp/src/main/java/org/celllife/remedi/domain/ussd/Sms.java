package org.celllife.remedi.domain.ussd;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * Smses sent entity for the USSD endpoint. Contains information about the smses
 * sent to the user
 */
@Entity
public class Sms implements Serializable {

	private static final long serialVersionUID = -7136503422359358269L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	private Long serviceId;
	private Long smsId;
	private String smsText;

	@OneToOne
	@JoinColumn(name = "request")
	private Request request;

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

	public Long getSmsId() {
		return smsId;
	}

	public void setSmsId(Long smsId) {
		this.smsId = smsId;
	}

	public String getSmsText() {
		return smsText;
	}

	public void setSmsText(String smsText) {
		this.smsText = smsText;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Sms [id=" + id + ", serviceId=" + serviceId + ", smsId="
				+ smsId + ", smsText=" + smsText + ", request="
				+ request.getId() + "]";
	}
}

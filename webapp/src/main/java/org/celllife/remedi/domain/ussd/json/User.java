package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -6578075368775887436L;

	private String msisdn;
	private String mnoCode;
	
	public User() {
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

	@Override
	public String toString() {
		return "User [msisdn=" + msisdn + ", mnoCode=" + mnoCode + "]";
	}
}

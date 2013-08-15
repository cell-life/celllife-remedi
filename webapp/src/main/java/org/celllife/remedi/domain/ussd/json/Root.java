package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public class Root implements Serializable {
	
	private static final long serialVersionUID = 2911038049026490513L;

	RemediUssdSubmissionRequest remediUssdSubmissionRequest;
	
	public Root() {
	}

	public RemediUssdSubmissionRequest getRemediUssdSubmissionRequest() {
		return remediUssdSubmissionRequest;
	}

	public void setRemediUssdSubmissionRequest(
			RemediUssdSubmissionRequest remediUssdSubmissionRequest) {
		this.remediUssdSubmissionRequest = remediUssdSubmissionRequest;
	}

	@Override
	public String toString() {
		return "Root [remediUssdSubmissionRequest="
				+ remediUssdSubmissionRequest + "]";
	}
}

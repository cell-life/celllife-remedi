package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;
import java.util.List;

public class SessionData implements Serializable {

	private static final long serialVersionUID = -5529865833114596510L;

	List<PageVisits> pageVisits;
	private Sms sms;
	
	public SessionData() {
	}

	public List<PageVisits> getPageVisits() {
		return pageVisits;
	}

	public void setPageVisits(List<PageVisits> pageVisits) {
		this.pageVisits = pageVisits;
	}
	
	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	@Override
	public String toString() {
		return "SessionData [pageVisits=" + pageVisits + ", sms=" + sms + "]";
	}
}

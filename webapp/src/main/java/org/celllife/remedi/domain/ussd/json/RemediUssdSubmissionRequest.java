package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;

public class RemediUssdSubmissionRequest implements Serializable {

	private static final long serialVersionUID = -2509724691685798269L;

	private UssdSession ussdSession;
	private User user;
	private Content content;
	private SessionData sessionData;
	
	public RemediUssdSubmissionRequest() {
	}

	public UssdSession getUssdSession() {
		return ussdSession;
	}

	public void setUssdSession(UssdSession ussdSession) {
		this.ussdSession = ussdSession;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public SessionData getSessionData() {
		return sessionData;
	}

	public void setSessionData(SessionData sessionData) {
		this.sessionData = sessionData;
	}

	@Override
	public String toString() {
		return "RemediUssdSubmissionRequest [ussdSession=" + ussdSession
				+ ", user=" + user + ", content=" + content + ", sessionData="
				+ sessionData + "]";
	}
}

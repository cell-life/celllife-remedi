package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;
import java.util.Date;

public final class UssdSession implements Serializable {

	private static final long serialVersionUID = 1722308069217250867L;

	private String id;
	private String string;
	private Date startDateTime;
	private Date endDateTime;

	public UssdSession() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public Date getStartDateTime() {
		return startDateTime;
	}

	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	public Date getEndDateTime() {
		return endDateTime;
	}

	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	@Override
	public String toString() {
		return "UssdSession [id=" + id + ", string=" + string
				+ ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + "]";
	}
}

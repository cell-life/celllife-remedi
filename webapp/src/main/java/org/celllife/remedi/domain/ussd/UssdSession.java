package org.celllife.remedi.domain.ussd;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * USSD Session entity for the USSD endpoint. Contains details about the session
 * (times)
 */
@Embeddable
public final class UssdSession implements Serializable {

	private static final long serialVersionUID = 5766201813161201442L;

	private String id;
	
	@Basic
	private String string;

	@Temporal(TemporalType.TIMESTAMP)
	private Date startDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date endDateTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return "UssdSession [id=" + id + ", string=" + string
				+ ", startDateTime=" + startDateTime + ", endDateTime="
				+ endDateTime + "]";
	}
}

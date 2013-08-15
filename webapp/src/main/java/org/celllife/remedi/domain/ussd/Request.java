package org.celllife.remedi.domain.ussd;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * Root Entity model for the USSD session data received. It contains information about each interaction with
 * the USSD menu. 
 * 
 * This includes information about the session itself (the timestamps) and the user (msisdn), as well as the 
 * content consumed (i.e. page viewed) by the user during the session. The data displayed to the user in this
 * case is information about medical services, which are grouped by Theme. The user can opt to receive 
 * an SMS containing the information about a particular service.
 */
@Entity
@Cacheable
public class Request implements Serializable {

	private static final long serialVersionUID = 2447706927325734934L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "id", column = @Column(name = "ussdSessionId")),
			@AttributeOverride(name = "string", column = @Column(name = "ussdSessionString")),
			@AttributeOverride(name = "startDateTime", column = @Column(name = "ussdSessionStartDateTime")),
			@AttributeOverride(name = "endDateTime", column = @Column(name = "ussdSessionEndDateTime")) })
	private UssdSession ussdSession;

	@Embedded
	@AttributeOverrides({
			@AttributeOverride(name = "msisdn", column = @Column(name = "userMsisdn")),
			@AttributeOverride(name = "mnoCode", column = @Column(name = "userMnoCode")) })
	private User user;

	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "version", column = @Column(name = "contentVersion")) })
	private Content content;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "request")
	private List<Theme> themes;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	private Sms sms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Theme> getThemes() {
		return themes;
	}

	public void setThemes(List<Theme> themes) {
		this.themes = themes;
	}

	public Sms getSms() {
		return sms;
	}

	public void setSms(Sms sms) {
		this.sms = sms;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", ussdSession=" + ussdSession + ", user="
				+ user + ", content=" + content + ", themes=" + themes
				+ ", sms=" + sms + "]";
	}
}

package org.celllife.remedi.domain.ussd;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * Theme (page visit) entity for the USSD endpoint. Contains information about the themes the user viewed
 */
@Entity
public class Theme implements Serializable {

	private static final long serialVersionUID = 7564371005698654945L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

	private Long themeId;
    private String themeTitle;  
    
    //@Fetch(FetchMode.JOIN)
    //@ElementCollection(fetch = FetchType.EAGER)
    //@JoinColumn(name = "theme")
    @OneToMany(cascade=CascadeType.ALL, mappedBy="theme")
    private List<Service> services;
    
    @ManyToOne
    @JoinColumn(name="request")
    private Request request;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }    
    
	public Long getThemeId() {
		return themeId;
	}

	public void setThemeId(Long themeId) {
		this.themeId = themeId;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		System.out.println("theme title="+themeTitle);
		this.themeTitle = themeTitle;
	}

	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		System.out.println("services:"+services+","+services.size());
		this.services = services;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "Theme [id=" + id + ", themeId=" + themeId + ", themeTitle="
				+ themeTitle + ", services=" + services + ", request="
				+ request.getId() + "]";
	}
}

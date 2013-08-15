package org.celllife.remedi.domain.ussd.json;

import java.io.Serializable;
import java.util.List;

public class PageVisits implements Serializable {

	private static final long serialVersionUID = 4109319469624251078L;

	private String themeId;
	private String themeTitle;
	private List<Services> services;
	
	public PageVisits() {
	}

	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getThemeTitle() {
		return themeTitle;
	}

	public void setThemeTitle(String themeTitle) {
		this.themeTitle = themeTitle;
	}

	public List<Services> getServices() {
		return services;
	}

	public void setServices(List<Services> services) {
		this.services = services;
	}

	@Override
	public String toString() {
		return "PageVisits [themeId=" + themeId + ", themeTitle=" + themeTitle
				+ ", services=" + services + "]";
	}
}

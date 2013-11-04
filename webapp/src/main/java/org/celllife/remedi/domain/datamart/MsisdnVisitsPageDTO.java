package org.celllife.remedi.domain.datamart;

import java.io.Serializable;

/**
 * DTO containing a page of individual clinic ratings, in DataTables format.
 * 
 * See more information here: http://www.datatables.net/usage/server-side
 * And http://datatables.net/development/server-side/jsp
 */
public class MsisdnVisitsPageDTO implements Serializable {

	private static final long serialVersionUID = 1227805378326624665L;

	private String sEcho;
	
	private Integer iTotalRecords;
	
	private Integer iTotalDisplayRecords;

	private String themeId;

    private String themeName;

    private String serviceId;

    private String serviceName;
	
	private Object[][] aaData;

    public MsisdnVisitsPageDTO() {
    }

    public MsisdnVisitsPageDTO(String sEcho, Integer iTotalRecords, Integer iTotalDisplayRecords, Object[][] aaData) {
    	this.sEcho = sEcho;
    	this.iTotalRecords = iTotalRecords;
    	this.iTotalDisplayRecords = iTotalDisplayRecords;
    	this.aaData = aaData;
    }

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public Object[][] getAaData() {
		return aaData;
	}

	public void setAaData(Object[][] aaData) {
		this.aaData = aaData;
	}

	public String getThemeId() {
		return themeId;
	}

	public void setThemeId(String themeId) {
		this.themeId = themeId;
	}

	public String getThemeName() {
		return themeName;
	}

	public void setThemeName(String themeName) {
		this.themeName = themeName;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	
}

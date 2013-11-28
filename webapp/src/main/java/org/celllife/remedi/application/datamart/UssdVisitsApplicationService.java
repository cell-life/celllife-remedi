package org.celllife.remedi.application.datamart;

import java.util.Date;
import java.util.List;

import org.celllife.remedi.domain.datamart.MsisdnVisitsDTO;
import org.celllife.remedi.domain.datamart.MsisdnVisitsPageDTO;
import org.celllife.remedi.domain.datamart.UssdPageVisitsDTO;

/**
 * Application Service for retrieval of UssdVisits and MsisdnVisits for use in Controllers 
 */
public interface UssdVisitsApplicationService {

	/**
	 * Retrieves a list of UssdPageVisits between a specified date range
	 */
    public List<UssdPageVisitsDTO> getUssdVisits(Date startDate, Date endDate);

    /**
     * Retrieves a list of MsisdnVisits between a specified date range
     */
    public MsisdnVisitsPageDTO getMsisdnVisits(Date startDate, Date endDate, 
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho);
    
    /**
     * Retrieves a list of MsisdnVisits between a specified date range for a specified service
     */
    public MsisdnVisitsPageDTO getMsisdnVisitsByService(Date startDate, Date endDate, String serviceId, String serviceName, 
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho);
    
    /**
     * Retrieves a list of MsisdnVisits between a specified date range for a specified theme
     */
    public MsisdnVisitsPageDTO getMsisdnVisitsByTheme(Date startDate, Date endDate, String themeId, String themeName, 
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho);
    
    /**
     * Retrieves a list of MsisdnVisits between a specified date range
     */
    public List<MsisdnVisitsDTO> getMsisdnVisits(Date startDate, Date endDate);
    
    /**
     * Retrieves a list of MsisdnVisits between a specified date range for a specified service
     */
    public List<MsisdnVisitsDTO> getMsisdnVisitsByService(Date startDate, Date endDate, String serviceId, String serviceName);
    
    /**
     * Retrieves a list of MsisdnVisits between a specified date range for a specified theme
     */
    public List<MsisdnVisitsDTO> getMsisdnVisitsByTheme (Date startDate, Date endDate, String themeId, String themeName);

}

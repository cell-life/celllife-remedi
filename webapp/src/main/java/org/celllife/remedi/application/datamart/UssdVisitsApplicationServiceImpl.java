package org.celllife.remedi.application.datamart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.celllife.remedi.domain.datamart.MsisdnVisitsDTO;
import org.celllife.remedi.domain.datamart.MsisdnVisitsPageDTO;
import org.celllife.remedi.domain.datamart.UssdPageVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdThemeVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdVisitsStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class UssdVisitsApplicationServiceImpl implements UssdVisitsApplicationService {
	
	private static String[] msisdnVisitColumns = new String[] { "ussdSessionId", "date", "startTime", "duration", "msisdn", "mno"};

    @Autowired
    private UssdVisitsStoreRepository ussdVisitsStoreRepository;


    public List<UssdPageVisitsDTO> getUssdVisits(Date startDate, Date endDate) {

        List<UssdPageVisitsDTO> ussdPageVisitsDTOs = new ArrayList<UssdPageVisitsDTO>();
        Collection<UssdThemeVisitsDTO> ussdThemeVisitsDTOs = ussdVisitsStoreRepository.findTotalVisitsPerTheme(startDate, endDate);

        for (UssdThemeVisitsDTO ussdThemeVisitsDTO : ussdThemeVisitsDTOs) {

            UssdPageVisitsDTO ussdPageVisitsDTO = new UssdPageVisitsDTO(ussdThemeVisitsDTO.getThemeId(), ussdThemeVisitsDTO.getThemeTitle(), ussdThemeVisitsDTO.getThemeVisits(), 0, true);
            ussdPageVisitsDTOs.add(ussdPageVisitsDTO);

            Collection<UssdServiceVisitsDTO> ussdServiceVisitsDTOs = ussdVisitsStoreRepository.findTotalVisitsPerServiceInTheme(startDate, endDate, ussdThemeVisitsDTO.getThemeId());
            for (UssdServiceVisitsDTO ussdServiceVisitsDTO : ussdServiceVisitsDTOs) {
                ussdPageVisitsDTO = new UssdPageVisitsDTO(ussdServiceVisitsDTO.getServiceId(), ussdServiceVisitsDTO.getServiceTitle(), ussdServiceVisitsDTO.getServiceVisits(), ussdServiceVisitsDTO.getSmses(), false);
                ussdPageVisitsDTOs.add(ussdPageVisitsDTO);
            }
        }

        return ussdPageVisitsDTOs;

    }

	@Override
	public MsisdnVisitsPageDTO getMsisdnVisits(Date startDate, Date endDate, 
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho) {
		
		Pageable pageable = createPageable(iDisplayStart, iDisplayLength, sSearch, iSortingCols,
			iSortCol_0, iSortCol_1,	iSortCol_2,	iSortCol_3,	iSortCol_4,	iSortCol_5,	iSortCol_6,
			sSortDir_0, sSortDir_1, sSortDir_2, sSortDir_3, sSortDir_4, sSortDir_5, sSortDir_6);
    	Page<MsisdnVisitsDTO> page = null;
    	if (sSearch != null && !sSearch.trim().equals("")) {
    		// do a search (only on msisdn)
    		page = ussdVisitsStoreRepository.findMsisdnVisitsByMsisdn(startDate, endDate, sSearch, pageable);
    	} else {
    		// just get the data
    		page = ussdVisitsStoreRepository.findMsisdnVisits(startDate, endDate, pageable);
    	}
		return createPageDTO(page, sEcho);
	}

	@Override
	public MsisdnVisitsPageDTO getMsisdnVisitsByService(Date startDate, Date endDate, String serviceId, String serviceName,  
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho) {

		Pageable pageable = createPageable(iDisplayStart, iDisplayLength, sSearch, iSortingCols,
				iSortCol_0, iSortCol_1,	iSortCol_2,	iSortCol_3,	iSortCol_4,	iSortCol_5,	iSortCol_6,
				sSortDir_0, sSortDir_1, sSortDir_2, sSortDir_3, sSortDir_4, sSortDir_5, sSortDir_6);
    	Page<MsisdnVisitsDTO> page = null;
    	if (sSearch != null && !sSearch.trim().equals("")) {
    		// do a search (only on msisdn)
    		page = ussdVisitsStoreRepository.findMsisdnVisitsByServiceAndMsisdn(startDate, endDate, serviceId, sSearch, pageable);
    	} else {
    		// just get the data
    		page = ussdVisitsStoreRepository.findMsisdnVisitsByService(startDate, endDate, serviceId, pageable);
    	}
    	MsisdnVisitsPageDTO pageDTO = createPageDTO(page, sEcho);
		pageDTO.setServiceId(serviceId);
		pageDTO.setServiceName(serviceName);
		return pageDTO;
	}

	@Override
	public MsisdnVisitsPageDTO getMsisdnVisitsByTheme(Date startDate, Date endDate, String themeId, String themeName,
    		Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6,
			String sEcho) {

		Pageable pageable = createPageable(iDisplayStart, iDisplayLength, sSearch, iSortingCols,
				iSortCol_0, iSortCol_1,	iSortCol_2,	iSortCol_3,	iSortCol_4,	iSortCol_5,	iSortCol_6,
				sSortDir_0, sSortDir_1, sSortDir_2, sSortDir_3, sSortDir_4, sSortDir_5, sSortDir_6);
    	Page<MsisdnVisitsDTO> page = null;
    	if (sSearch != null && !sSearch.trim().equals("")) {
    		// do a search (only on msisdn)
    		page = ussdVisitsStoreRepository.findMsisdnVisitsByThemeAndMsisdn(startDate, endDate, themeId, sSearch, pageable);
    	} else {
    		// just get the data
    		page = ussdVisitsStoreRepository.findMsisdnVisitsByTheme(startDate, endDate, themeId, pageable);
    	}
    	MsisdnVisitsPageDTO pageDTO = createPageDTO(page, sEcho);
		pageDTO.setThemeId(themeId);
		pageDTO.setThemeName(themeName);
		return pageDTO;
	}
    

	private Pageable createPageable(Integer iDisplayStart, Integer iDisplayLength, String sSearch, Integer iSortingCols,
			Integer iSortCol_0, Integer iSortCol_1,	Integer iSortCol_2,	Integer iSortCol_3,	Integer iSortCol_4,	Integer iSortCol_5,	Integer iSortCol_6,
			String sSortDir_0, String sSortDir_1, String sSortDir_2, String sSortDir_3, String sSortDir_4, String sSortDir_5, String sSortDir_6) {
		// create the page request with sorting and page specified
		Sort sort = null;
		if (iSortingCols != null && iSortingCols > 0) {
			sort = createSort(iSortCol_0, sSortDir_0);
			if (sort != null) {
				sort.and(createSort(iSortCol_1, sSortDir_1));
				sort.and(createSort(iSortCol_2, sSortDir_2));
				sort.and(createSort(iSortCol_3, sSortDir_3));
				sort.and(createSort(iSortCol_4, sSortDir_4));
				sort.and(createSort(iSortCol_5, sSortDir_5));
				sort.and(createSort(iSortCol_6, sSortDir_6));
			}
		}
    	return new PageRequest((iDisplayStart/iDisplayLength),iDisplayLength, sort);
	}
	
	private Sort createSort(Integer col, String dir) {
		Sort sort = null;
		if (col != null && col >= 0) {
			sort = new Sort((dir.equals("asc") ? Direction.ASC : Direction.DESC), msisdnVisitColumns[col]);
		}
		return sort;
	}
	
	private MsisdnVisitsPageDTO createPageDTO(Page<MsisdnVisitsDTO> page, String sEcho) {
		// translate to the correct format for the UI
    	MsisdnVisitsPageDTO pageDTO = new MsisdnVisitsPageDTO();
		pageDTO.setsEcho(sEcho);
		pageDTO.setiTotalDisplayRecords((int)page.getTotalElements()); // FIXME: haven't implemented filtering on search field
		pageDTO.setiTotalRecords((int)page.getTotalElements());
		Object[][] aaData = new Object[page.getNumberOfElements()][];
		Iterator<MsisdnVisitsDTO> it = page.iterator();
		int row = 0;
		while (it.hasNext()) {
			MsisdnVisitsDTO dto = it.next();
			String mobileNetwork = (dto.getMobileNetwork() == null ? "" : dto.getMobileNetwork().getDescription());
			if (mobileNetwork == null)
			aaData[row] = new Object[] { 
					dto.getUssdSessionId(),
					new SimpleDateFormat("dd MMM yyyy").format(dto.getStart()),
					new SimpleDateFormat("HH:mm:ss").format(dto.getStart()),
					dto.getDuration(),
					dto.getMsisdn(), 
					mobileNetwork
					};
			row++;
		}
		pageDTO.setAaData(aaData);
		return pageDTO;
	}
}

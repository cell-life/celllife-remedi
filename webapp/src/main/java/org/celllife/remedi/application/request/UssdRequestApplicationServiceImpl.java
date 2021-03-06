package org.celllife.remedi.application.request;

import java.util.ArrayList;
import java.util.List;

import org.celllife.remedi.domain.datamart.UssdPageVisit;
import org.celllife.remedi.domain.datamart.UssdVisitsStoreRepository;
import org.celllife.remedi.domain.ussd.Request;
import org.celllife.remedi.domain.ussd.RequestRepository;
import org.celllife.remedi.domain.ussd.Service;
import org.celllife.remedi.domain.ussd.Theme;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class UssdRequestApplicationServiceImpl implements UssdRequestApplicationService {
	
	private static Logger log = LoggerFactory.getLogger(UssdRequestApplicationServiceImpl.class);
	
	@Autowired
	RequestRepository requestRepository;
	
	@Autowired
	UssdVisitsStoreRepository ussdVisitsStoreRepository;

	@Override
	public Request save(Request request) {
		Request savedRequest = null;
		if (isDuplicate(request)) {
			log.error("Cannot save request because it is a duplicate request="+request);
		} else {
			savedRequest = requestRepository.save(request);
			List<UssdPageVisit> ussdPageVisits = convertToUssdPageVisits(savedRequest);
			if (log.isTraceEnabled()) {
				log.trace("converted Request into UssdPageVisits: "+ussdPageVisits);
			}
			ussdVisitsStoreRepository.save(ussdPageVisits);
		}
		return savedRequest;
	}
	
	boolean isDuplicate(Request request) {
		boolean duplicate = false;
		try {
			Iterable<Request> duplicateRequests = requestRepository.findByUssdSessionId(request.getUssdSession().getId());
			if (duplicateRequests.iterator().hasNext()) {
				duplicate = true;
				System.out.println("duplicate "+request.getUssdSession().getId());
			}
		} catch (Exception e) {
			log.warn("Could not find duplicate requests with ussd session id '"+request.getUssdSession().getId()+"' due to error '"+e.getMessage()+"'");
		}
		return duplicate;
	}
	
	List<UssdPageVisit> convertToUssdPageVisits(Request request) {
		List<UssdPageVisit> pageVisits = new ArrayList<UssdPageVisit>();
		for (Theme theme : request.getThemes()) {
			UssdPageVisit themePageVisit = new UssdPageVisit(request.getUssdSession().getId(), 
					request.getUssdSession().getStartDateTime(), request.getUssdSession().getEndDateTime(),
					request.getUser().getMsisdn(), request.getUser().getMnoCode(), request.getContent().getVersion());
			themePageVisit.setThemeId(theme.getThemeId());
			themePageVisit.setThemeTitle(theme.getThemeTitle());
			pageVisits.add(themePageVisit);
			for (Service service : theme.getServices()) {
				UssdPageVisit servicePageVisit = new UssdPageVisit(request.getUssdSession().getId(), 
						request.getUssdSession().getStartDateTime(), request.getUssdSession().getEndDateTime(),
						request.getUser().getMsisdn(), request.getUser().getMnoCode(), request.getContent().getVersion());
				servicePageVisit.setThemeId(theme.getThemeId());
				servicePageVisit.setThemeTitle(theme.getThemeTitle());
				servicePageVisit.setServiceId(service.getServiceId());
				servicePageVisit.setServiceTitle(service.getServiceTitle());
				if (request.getSms() != null && service.getServiceId().equals(request.getSms().getServiceId())) {
					servicePageVisit.setSmsId(request.getSms().getSmsId());
				}
				pageVisits.add(servicePageVisit);
			}
		}
		return pageVisits;
	}
}
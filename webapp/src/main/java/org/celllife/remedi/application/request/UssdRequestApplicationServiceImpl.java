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
		Request savedRequest = requestRepository.save(request);
		List<UssdPageVisit> ussdPageVisits = convertToUssdPageVisits(savedRequest);
		if (log.isTraceEnabled()) {
			log.trace("converted Request into UssdPageVisits: "+ussdPageVisits);
		}
		ussdVisitsStoreRepository.save(ussdPageVisits);
		return savedRequest;
	}
	
	List<UssdPageVisit> convertToUssdPageVisits(Request request) {
		List<UssdPageVisit> pageVisits = new ArrayList<UssdPageVisit>();
		for (Theme theme : request.getThemes()) {
			for (Service service : theme.getServices()) {
				UssdPageVisit pageVisit = new UssdPageVisit();
				pageVisit.setContentVersion(request.getContent().getVersion());
				pageVisit.setUssdSessionId(request.getUssdSession().getId());
				pageVisit.setMsisdn(request.getUser().getMsisdn());
				pageVisit.setMnoCode(request.getUser().getMnoCode());
				pageVisit.setDate(request.getUssdSession().getStartDateTime());
				pageVisit.setThemeId(theme.getThemeId());
				pageVisit.setThemeTitle(theme.getThemeTitle());
				pageVisit.setServiceId(service.getServiceId());
				pageVisit.setServiceTitle(service.getServiceTitle());
				if (request.getSms() != null && service.getServiceId().equals(request.getSms().getServiceId())) {
					pageVisit.setSmsId(request.getSms().getSmsId());
				}
				pageVisits.add(pageVisit);
			}
		}
		return pageVisits;
	}
}
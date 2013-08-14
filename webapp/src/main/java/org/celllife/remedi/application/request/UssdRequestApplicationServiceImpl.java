package org.celllife.remedi.application.request;

import org.celllife.remedi.domain.ussd.Request;
import org.celllife.remedi.domain.ussd.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UssdRequestApplicationServiceImpl implements UssdRequestApplicationService {
	
	@Autowired
	RequestRepository requestRepository;

	@Override
	public Request save(Request request) {
		Request savedRequest = requestRepository.save(request);
		// FIXME: do the export to the datamart tables here
		return savedRequest;
	}

}

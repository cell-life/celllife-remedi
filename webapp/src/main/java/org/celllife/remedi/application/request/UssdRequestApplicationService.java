package org.celllife.remedi.application.request;

import org.celllife.remedi.domain.ussd.Request;

/**
 * Application service for the USSD Request entity
 */
public interface UssdRequestApplicationService {
	
	/**
	 * Persists the Request object into the storage 
	 * @param request Request object to save 
	 * @return Request object, saved (with ids)
	 */
	Request save(Request request);
}

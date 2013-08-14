package org.celllife.remedi.application.request;

import org.celllife.remedi.domain.ussd.Request;

/**
 * Application service for the USSD Request entity
 */
public interface UssdRequestApplicationService {

	Request save(Request request);
}

package org.celllife.remedi.integration.ussd;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.celllife.remedi.application.request.UssdRequestApplicationService;
import org.celllife.remedi.domain.ussd.Content;
import org.celllife.remedi.domain.ussd.Request;
import org.celllife.remedi.domain.ussd.Service;
import org.celllife.remedi.domain.ussd.Sms;
import org.celllife.remedi.domain.ussd.Theme;
import org.celllife.remedi.domain.ussd.User;
import org.celllife.remedi.domain.ussd.UssdSession;
import org.celllife.remedi.domain.ussd.json.PageVisits;
import org.celllife.remedi.domain.ussd.json.Root;
import org.celllife.remedi.domain.ussd.json.Services;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;

@org.springframework.stereotype.Service("remediUssdSubmissionMediator")
public class RemediUssdSubmissionMediator {
	
	private static Logger log = LoggerFactory.getLogger(RemediUssdSubmissionMediator.class);

    public static final String HAPPY_RESULT = "{ \"RemediUssdSubmissionResponse\": { \"message\": \"Completed Successfully\" } }";

    @Autowired
    private UssdRequestApplicationService ussdRequestApplicationService;

    public Message<String> handleRemediUssdSubmission(Message<byte[]> message) throws JsonProcessingException, IOException {     
    	String payload = new String(message.getPayload());
    	if (log.isDebugEnabled()) {
    		log.debug("ussd submission payload: "+payload);
    	}
		Root root = new ObjectMapper().readValue(payload, Root.class);
		Request request = convertRootToRequest(root);
		request = ussdRequestApplicationService.save(request);
		if (log.isDebugEnabled()) {
    		log.debug("ussd submission request object: "+request);
    	}
		return new GenericMessage<>(HAPPY_RESULT);
    }
    
    Root convertPayloadToRoot(String payload) throws JsonProcessingException, IOException  {
    	// using jackson not smooks because i found that the recursive/nested array did not work
    	return new ObjectMapper().readValue(payload, Root.class);
    }
    
    Request convertRootToRequest(Root root) {
    	// code smell: could (should) do this using a library
    	Request request = new Request();
    	
    	UssdSession ussdSession = new UssdSession();
    	request.setUssdSession(ussdSession);
    	ussdSession.setString(root.getRemediUssdSubmissionRequest().getUssdSession().getString());
    	ussdSession.setEndDateTime(root.getRemediUssdSubmissionRequest().getUssdSession().getEndDateTime());
    	ussdSession.setStartDateTime(root.getRemediUssdSubmissionRequest().getUssdSession().getStartDateTime());
    	ussdSession.setId(root.getRemediUssdSubmissionRequest().getUssdSession().getId());
    	
    	User user = new User();
    	request.setUser(user);
    	user.setMsisdn(root.getRemediUssdSubmissionRequest().getUser().getMsisdn());
    	user.setMnoCode(root.getRemediUssdSubmissionRequest().getUser().getMnoCode());

    	Content content = new Content();
    	request.setContent(content);
    	content.setVersion(root.getRemediUssdSubmissionRequest().getContent().getVersion());
    	
    	List<Theme> themes = new ArrayList<Theme>();
    	for (PageVisits pageVisit : root.getRemediUssdSubmissionRequest().getSessionData().getPageVisits()) {
    		Theme theme = new Theme();
    		theme.setRequest(request);
    		themes.add(theme);
    		theme.setThemeId(pageVisit.getThemeId());
    		theme.setThemeTitle(pageVisit.getThemeTitle());
    		List<Service> services = new ArrayList<Service>();
    		theme.setServices(services);
    		for (Services s : pageVisit.getServices()) {
	    		Service service = new Service();
	    		service.setTheme(theme);
	    		service.setServiceId(s.getServiceId());
	    		service.setServiceTitle(s.getServiceTitle());
	    		service.setServiceDescription(s.getServiceDescription());
	    		services.add(service);
    		}
    	}
    	request.setThemes(themes);
    	
    	Sms sms = new Sms();
    	sms.setRequest(request);
    	request.setSms(sms);
    	sms.setServiceId(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getServiceId());
    	sms.setSmsId(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getSmsId());
    	sms.setSmsText(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getSmsText());
    	
    	return request;
    }

}

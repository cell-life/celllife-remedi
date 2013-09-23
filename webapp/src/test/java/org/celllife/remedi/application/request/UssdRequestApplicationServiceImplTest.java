package org.celllife.remedi.application.request;

import java.util.ArrayList;
import java.util.Date;

import org.celllife.remedi.domain.ussd.Content;
import org.celllife.remedi.domain.ussd.Request;
import org.celllife.remedi.domain.ussd.RequestRepository;
import org.celllife.remedi.domain.ussd.Sms;
import org.celllife.remedi.domain.ussd.Theme;
import org.celllife.remedi.domain.ussd.User;
import org.celllife.remedi.domain.ussd.UssdSession;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
	"classpath:/META-INF/spring/spring-aop.xml",
	"classpath:/META-INF/spring/spring-application.xml",
    "classpath:/META-INF/spring/spring-cache.xml",
    "classpath:/META-INF/spring/spring-config.xml",
    "classpath:/META-INF/spring/spring-domain.xml",
    "classpath:/META-INF/spring/spring-integration-ussd.xml",
    "classpath:/META-INF/spring/spring-jdbc.xml",
    "classpath:/META-INF/spring/spring-json.xml",
    "classpath:/META-INF/spring/spring-mvc.xml",
    "classpath:/META-INF/spring/spring-orm.xml",
    "classpath:/META-INF/spring/spring-task.xml",
    "classpath:/META-INF/spring/spring-tx.xml",
    "classpath:/META-INF/spring-data/spring-data-jpa.xml",
    "classpath:/META-INF/spring-integration/spring-integration-core.xml",
})
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class UssdRequestApplicationServiceImplTest {
	
	@Autowired
	private UssdRequestApplicationService ussdRequestApplicationService;
	
	@Autowired
	RequestRepository requestRepository;
	

	@Test
	@Rollback(true)
	public void testHasDuplicates() throws Exception {
		Request request = createRequest("123456");
		Request savedRequest1 = null, savedRequest2 = null;
		try {
			savedRequest1 = ussdRequestApplicationService.save(request);
			Assert.assertNotNull("first request is saved", savedRequest1);
			savedRequest2 = ussdRequestApplicationService.save(request);
			Assert.assertNull("second request is not saved", savedRequest2);
		} finally {
			// FIXME tear down manually because rollback doesn't seem to be working
			if (savedRequest1 != null)
				requestRepository.delete(savedRequest1.getId());
		}
	}
	
	@Test
	@Rollback(true)
	public void testNoDuplicates() throws Exception {
		Request request1 = createRequest("123456");
		Request request2 = createRequest("456789");
		Request savedRequest1 = null, savedRequest2 = null;
		try {
			savedRequest1 = ussdRequestApplicationService.save(request1);
			Assert.assertNotNull("first request is saved", savedRequest1);
			savedRequest2 = ussdRequestApplicationService.save(request2);
			Assert.assertNotNull("second request is saved", savedRequest2);
		} finally {
			// FIXME tear down manually because rollback doesn't seem to be working
			if (savedRequest1 != null)
				requestRepository.delete(savedRequest1.getId());
			if (savedRequest2 != null)
				requestRepository.delete(savedRequest2.getId());
		}
	}

	private Request createRequest(String ussdSessionId) {
		Request request = new Request();
		request.setUser(new User());
		UssdSession ussdSession = new UssdSession();
		ussdSession.setId(ussdSessionId);
		ussdSession.setStartDateTime(new Date());
		ussdSession.setString("*123*3444#");
		Sms sms = new Sms();
		sms.setRequest(request);
		request.setSms(sms);
		request.setThemes(new ArrayList<Theme>());
		request.setContent(new Content());
		request.setUssdSession(ussdSession);
		return request;
	}
}

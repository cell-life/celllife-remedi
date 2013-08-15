package org.celllife.remedi.integration.ussd;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.celllife.remedi.domain.ussd.Request;
import org.celllife.remedi.domain.ussd.Service;
import org.celllife.remedi.domain.ussd.Theme;
import org.celllife.remedi.domain.ussd.json.PageVisits;
import org.celllife.remedi.domain.ussd.json.Root;
import org.celllife.remedi.domain.ussd.json.Services;
import org.celllife.remedi.test.TestConfiguration;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class RemediUssdSubmissionMediatorIntegrationTest {

    @Autowired
    private RemediUssdSubmissionMediator remediUssdSubmissionMediator;

    @Test
    //@Ignore("cannot save UssdPageVisit object")
    public void testHandleRemediUssdSubmission() throws Exception {
    	String json = IOUtils.toString(ClassLoader.getSystemResourceAsStream("json/request.json"));
        final GenericMessage<byte[]> input = new GenericMessage<>(json.getBytes());
        Message<String> result = remediUssdSubmissionMediator.handleRemediUssdSubmission(input);
        Assert.assertEquals(RemediUssdSubmissionMediator.HAPPY_RESULT, result.getPayload());
    }
    
    @Test
    public void testConvertPayloadToRoot() throws Exception {
    	String json = IOUtils.toString(ClassLoader.getSystemResourceAsStream("json/request.json"));
    	Root root = remediUssdSubmissionMediator.convertPayloadToRoot(json);
    	Assert.assertNotNull(root);
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest());
    	
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getContent());
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getContent().getVersion(), "1.0");
    	
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getUser());
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUser().getMsisdn(), "27721234567");
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUser().getMnoCode(), "1");
    	
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getUssdSession());
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUssdSession().getId(), "1");
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUssdSession().getString(), "*130*555*1000#");
    	//SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    	//Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUssdSession().getStartDateTime(), dateFormatter.parse("2012-01-01T20:00:00"));
    	//Assert.assertEquals(root.getRemediUssdSubmissionRequest().getUssdSession().getEndDateTime(), dateFormatter.parse("2012-01-01T20:00:00"));
    	
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getSessionData());
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getSessionData().getPageVisits());
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getSessionData().getPageVisits().size(), 2);
    	
    	PageVisits pageVisits1 = root.getRemediUssdSubmissionRequest().getSessionData().getPageVisits().get(0);
		Assert.assertEquals(pageVisits1.getThemeTitle(), "Pregnancy & childcare");
		Assert.assertEquals(pageVisits1.getThemeId(), "2");
		Assert.assertNotNull(pageVisits1.getServices());
		Assert.assertEquals(pageVisits1.getServices().size(), 2);
		Services services1 = pageVisits1.getServices().get(0);
		Assert.assertEquals(services1.getServiceId(), "25");
		Assert.assertEquals(services1.getServiceTitle(), "The Baby Club (SMS, mobi)");
		Assert.assertEquals(services1.getServiceDescription(), "Supports new & expectant parents every step of the way - info, weekly messages & more: SMS 32015 (R1 then FREE) thebabyapp.com");
		Services services2 = pageVisits1.getServices().get(1);
		Assert.assertEquals(services2.getServiceId(), "24");
		Assert.assertEquals(services2.getServiceTitle(), "MAMA (SMS, quiz, mobi)");
		Assert.assertEquals(services2.getServiceDescription(), "1. MAMA Monday (quiz)\\n2. MAMA (mobi)\\n3. MAMA (SMSs for a year)\\n4. MAMA (SMSs for 5 months)");
		
    	PageVisits pageVisits2 = root.getRemediUssdSubmissionRequest().getSessionData().getPageVisits().get(1);
		Assert.assertEquals(pageVisits2.getThemeTitle(), "Sex & family planning");
		Assert.assertEquals(pageVisits2.getThemeId(), "1");
		Assert.assertNotNull(pageVisits2.getServices());
		Assert.assertEquals(pageVisits2.getServices().size(), 1);
		Services services3 = pageVisits2.getServices().get(0);
		Assert.assertEquals(services3.getServiceId(), "11");
		Assert.assertEquals(services3.getServiceTitle(), "smrtSex (Mxit, mobi)");
		Assert.assertEquals(services3.getServiceDescription(), "Free advice, info & support on sex & relationships: smrtsex.mobi Mxit: My Contacts>Apps>Apps by Category>Advice>smrtSex");

    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getSessionData().getSms());
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getServiceId(), "24");
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getServiceId(), "24");
    	Assert.assertEquals(root.getRemediUssdSubmissionRequest().getSessionData().getSms().getSmsText(), "On Mxit:Tradepost>Reach>Health>Babyinfo");
    }
    
    @Test
    public void testConvertRootToRequest() throws Exception {
    	String json = IOUtils.toString(ClassLoader.getSystemResourceAsStream("json/request.json"));
    	Root root = remediUssdSubmissionMediator.convertPayloadToRoot(json);
    	Request request = remediUssdSubmissionMediator.convertRootToRequest(root);
    	
    	Assert.assertNotNull(request);
    	
    	Assert.assertNotNull(request.getContent());
    	Assert.assertEquals(request.getContent().getVersion(), "1.0");
    	
    	Assert.assertNotNull(request.getUser());
    	Assert.assertEquals(request.getUser().getMsisdn(), "27721234567");
    	Assert.assertEquals(request.getUser().getMnoCode(), "1");
    	
    	Assert.assertNotNull(request.getUssdSession());
    	Assert.assertEquals(request.getUssdSession().getId(), "1");
    	Assert.assertEquals(request.getUssdSession().getString(), "*130*555*1000#");
    	Assert.assertEquals(request.getUssdSession().getStartDateTime(), root.getRemediUssdSubmissionRequest().getUssdSession().getStartDateTime());
    	Assert.assertEquals(request.getUssdSession().getEndDateTime(), root.getRemediUssdSubmissionRequest().getUssdSession().getEndDateTime());
    	
    	Assert.assertNotNull(root.getRemediUssdSubmissionRequest().getSessionData());
    	Assert.assertNotNull(request.getThemes());
    	Assert.assertEquals(request.getThemes().size(), 2);
    	
    	Theme theme1 = request.getThemes().get(0);
		Assert.assertEquals(theme1.getThemeTitle(), "Pregnancy & childcare");
		Assert.assertEquals(theme1.getThemeId(), "2");
		Assert.assertNotNull(theme1.getServices());
		Assert.assertEquals(theme1.getServices().size(), 2);
		Service services1 = theme1.getServices().get(0);
		Assert.assertEquals(services1.getServiceId(), "25");
		Assert.assertEquals(services1.getServiceTitle(), "The Baby Club (SMS, mobi)");
		Assert.assertEquals(services1.getServiceDescription(), "Supports new & expectant parents every step of the way - info, weekly messages & more: SMS 32015 (R1 then FREE) thebabyapp.com");
		Service services2 = theme1.getServices().get(1);
		Assert.assertEquals(services2.getServiceId(), "24");
		Assert.assertEquals(services2.getServiceTitle(), "MAMA (SMS, quiz, mobi)");
		Assert.assertEquals(services2.getServiceDescription(), "1. MAMA Monday (quiz)\\n2. MAMA (mobi)\\n3. MAMA (SMSs for a year)\\n4. MAMA (SMSs for 5 months)");
		
    	Theme theme2 = request.getThemes().get(1);
		Assert.assertEquals(theme2.getThemeTitle(), "Sex & family planning");
		Assert.assertEquals(theme2.getThemeId(), "1");
		Assert.assertNotNull(theme2.getServices());
		Assert.assertEquals(theme2.getServices().size(), 1);
		Service services3 = theme2.getServices().get(0);
		Assert.assertEquals(services3.getServiceId(), "11");
		Assert.assertEquals(services3.getServiceTitle(), "smrtSex (Mxit, mobi)");
		Assert.assertEquals(services3.getServiceDescription(), "Free advice, info & support on sex & relationships: smrtsex.mobi Mxit: My Contacts>Apps>Apps by Category>Advice>smrtSex");

    	Assert.assertNotNull(request.getSms());
    	Assert.assertEquals(request.getSms().getServiceId(), "24");
    	Assert.assertEquals(request.getSms().getServiceId(), "24");
    	Assert.assertEquals(request.getSms().getSmsText(), "On Mxit:Tradepost>Reach>Health>Babyinfo");
    }
}

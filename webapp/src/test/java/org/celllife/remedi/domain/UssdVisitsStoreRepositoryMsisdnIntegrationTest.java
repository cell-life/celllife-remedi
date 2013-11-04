package org.celllife.remedi.domain;

import java.util.Calendar;
import java.util.Date;

import junit.framework.Assert;

import org.celllife.remedi.domain.datamart.MsisdnVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdPageVisit;
import org.celllife.remedi.domain.datamart.UssdVisitsStoreRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/META-INF/spring/spring-cache.xml", "classpath:/META-INF/spring/spring-config.xml",
		"classpath:/META-INF/spring/spring-domain.xml", "classpath:/META-INF/spring/spring-jdbc.xml",
		"classpath:/META-INF/spring/spring-orm.xml", "classpath:/META-INF/spring/spring-tx.xml",
		"classpath:/META-INF/spring-data/spring-data-jpa.xml" })
public class UssdVisitsStoreRepositoryMsisdnIntegrationTest {

	@Autowired
	private UssdVisitsStoreRepository ussdVisitsStoreRepository;

	private Date yesterday, dayBeforeYesterday, tomorrow;
	
	private Pageable pageable;

	@Before
	public void setUp() throws Exception {
		pageable = new PageRequest(0,50);

		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		yesterday = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, -1);
		dayBeforeYesterday = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 3);
		tomorrow = cal.getTime();

		ussdVisitsStoreRepository.deleteAll();
		
		cal.setTime(yesterday);
		cal.add(Calendar.MINUTE, 25);

		UssdPageVisit ussdVisit = new UssdPageVisit();
		ussdVisit.setUssdSessionId("1");
		ussdVisit.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 2);
		ussdVisit.setEndDate(cal.getTime());
		ussdVisit.setMsisdn("27724194151");
		ussdVisit.setMnoCode("1");
		ussdVisit.setContentVersion("1");
		ussdVisit.setServiceId("1");
		ussdVisit.setServiceTitle("smrtSex");
		ussdVisit.setThemeId("1");
		ussdVisit.setThemeTitle("Sex & Family Planning");
		ussdVisitsStoreRepository.save(ussdVisit);

		cal.add(Calendar.HOUR, 5);
		UssdPageVisit ussdVisit2 = new UssdPageVisit();
		ussdVisit2.setUssdSessionId("2");
		ussdVisit2.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 1);
		ussdVisit2.setEndDate(cal.getTime());
		ussdVisit2.setMsisdn("27724194152");
		ussdVisit.setMnoCode("1");
		ussdVisit2.setContentVersion("1");
		ussdVisit2.setServiceId("2");
		ussdVisit2.setServiceTitle("iChooseWhen");
		ussdVisit2.setThemeId("1");
		ussdVisit2.setThemeTitle("Sex & Family Planning");
		ussdVisitsStoreRepository.save(ussdVisit2);

		cal.add(Calendar.HOUR, 2);
		UssdPageVisit ussdVisit3 = new UssdPageVisit();
		ussdVisit3.setUssdSessionId("3");
		ussdVisit3.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 1);
		ussdVisit3.setEndDate(cal.getTime());
		ussdVisit3.setMsisdn("27724194153");
		ussdVisit.setMnoCode("1");
		ussdVisit3.setContentVersion("1");
		ussdVisit3.setServiceId("2");
		ussdVisit3.setServiceTitle("iChooseWhen");
		ussdVisit3.setThemeId("1");
		ussdVisit3.setThemeTitle("Sex & Family Planning");
		ussdVisit3.setSmsId("2");
		ussdVisitsStoreRepository.save(ussdVisit3);
		
		cal.add(Calendar.HOUR, 8);
		UssdPageVisit ussdVisit4 = new UssdPageVisit();
		ussdVisit4.setUssdSessionId("4");
		ussdVisit4.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 1);
		ussdVisit4.setEndDate(cal.getTime());
		ussdVisit4.setMsisdn("27724194155");
		ussdVisit.setMnoCode("1");
		ussdVisit4.setContentVersion("1");
		ussdVisit4.setServiceId("3");
		ussdVisit4.setServiceTitle("BabyInfo");
		ussdVisit4.setThemeId("2");
		ussdVisit4.setThemeTitle("Pregnancy & Childcare");
		ussdVisitsStoreRepository.save(ussdVisit4);

		cal.add(Calendar.HOUR, 1);
		UssdPageVisit ussdVisit5 = new UssdPageVisit();
		ussdVisit5.setUssdSessionId("5");
		ussdVisit5.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 1);
		ussdVisit5.setEndDate(cal.getTime());
		ussdVisit5.setMsisdn("27724194154");
		ussdVisit.setMnoCode("1");
		ussdVisit5.setContentVersion("1");
		ussdVisit5.setThemeId("1");
		ussdVisit5.setThemeTitle("Sex & Family Planning");
		ussdVisitsStoreRepository.save(ussdVisit5);

		cal.add(Calendar.HOUR, 3);
		UssdPageVisit ussdVisit6 = new UssdPageVisit();
		ussdVisit6.setUssdSessionId("6");
		ussdVisit6.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 1);
		ussdVisit6.setEndDate(cal.getTime());
		ussdVisit6.setMsisdn("27724194158");
		ussdVisit.setMnoCode("1");
		ussdVisit6.setContentVersion("1");
		ussdVisit6.setThemeId("2");
		ussdVisit6.setThemeTitle("Pregnancy & Childcare");
		ussdVisitsStoreRepository.save(ussdVisit6);
	}

	@Test
	public void testFindTotalVisits() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisits(dayBeforeYesterday, tomorrow, pageable);
		Assert.assertEquals(6, result.getNumberOfElements());
		Assert.assertNotNull(result.iterator().next().getMsisdn());
	}

	@Test
	public void testFindTotalVisitsPerService() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisitsByService(yesterday, new Date(),"3", pageable);
		Assert.assertEquals(1, result.getNumberOfElements());
		Assert.assertEquals("27724194155", result.iterator().next().getMsisdn());
	}

	@Test
	public void testFindTotalVisitsPerTheme() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisitsByTheme(yesterday, new Date(),"1", pageable);
		Assert.assertEquals(4, result.getNumberOfElements());
		Assert.assertNotNull(result.iterator().next().getMsisdn());
	}
	
	@Test
	public void testFindTotalVisitsSearchMsisdn() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisitsByMsisdn(yesterday, new Date(), "158", pageable);
		Assert.assertEquals(1, result.getNumberOfElements());
		Assert.assertEquals("27724194158", result.iterator().next().getMsisdn());
	}

	@Test
	public void testFindTotalVisitsPerServiceSearchMsisdn() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisitsByServiceAndMsisdn(yesterday, new Date(),"3", "4194", pageable);
		Assert.assertEquals(1, result.getNumberOfElements());
		Assert.assertEquals("27724194155", result.iterator().next().getMsisdn());
	}

	@Test
	public void testFindTotalVisitsPerThemeSearchMsisdn() {
		Page<MsisdnVisitsDTO> result = ussdVisitsStoreRepository.findMsisdnVisitsByThemeAndMsisdn(yesterday, new Date(),"1", "4153", pageable);
		Assert.assertEquals(1, result.getNumberOfElements());
		Assert.assertEquals("27724194153", result.iterator().next().getMsisdn());
	}
}

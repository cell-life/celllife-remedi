package org.celllife.remedi.domain;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({
        "classpath:/META-INF/spring/spring-cache.xml",
        "classpath:/META-INF/spring/spring-config.xml",
        "classpath:/META-INF/spring/spring-domain.xml",
        "classpath:/META-INF/spring/spring-jdbc.xml",
        "classpath:/META-INF/spring/spring-orm.xml",
        "classpath:/META-INF/spring/spring-tx.xml",
        "classpath:/META-INF/spring-data/spring-data-jpa.xml"
})
public class UssdServiceHitRepositoryIntegrationTest {

        @Autowired
        private UssdServiceHitRepository ussdHitsStoreRepository;

        private Date yesterday;

        @Before
        public void setUp() throws Exception {

            yesterday = new SimpleDateFormat("yyyyMMdd").parse(
                    ""+(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date()))-1));

            ussdHitsStoreRepository.deleteAll();

            UssdServiceHit ussdServiceHit = new UssdServiceHit();
            ussdServiceHit.setId("1");
            ussdServiceHit.setUssdSessionId("1");
            ussdServiceHit.setDate(new Date());
            ussdServiceHit.setMsisdn("27724194158");
            ussdServiceHit.setContentVersion(1);
            ussdServiceHit.setServiceId(1);
            ussdServiceHit.setServiceTitle("smrtSex");
            ussdServiceHit.setThemeId(1);
            ussdServiceHit.setThemeTitle("Sex & Family Planning");
            ussdHitsStoreRepository.save(ussdServiceHit);

            UssdServiceHit ussdServiceHit2 = new UssdServiceHit();
            ussdServiceHit2.setId("2");
            ussdServiceHit2.setUssdSessionId("2");
            ussdServiceHit2.setDate(new Date());
            ussdServiceHit2.setMsisdn("27724194158");
            ussdServiceHit2.setContentVersion(1);
            ussdServiceHit2.setServiceId(2);
            ussdServiceHit2.setServiceTitle("iChooseWhen");
            ussdServiceHit2.setThemeId(1);
            ussdServiceHit2.setThemeTitle("Sex & Family Planning");
            ussdHitsStoreRepository.save(ussdServiceHit2);

            UssdServiceHit ussdServiceHit3 = new UssdServiceHit();
            ussdServiceHit3.setId("3");
            ussdServiceHit3.setUssdSessionId("3");
            ussdServiceHit3.setDate(new Date());
            ussdServiceHit3.setMsisdn("27724194158");
            ussdServiceHit3.setContentVersion(1);
            ussdServiceHit3.setServiceId(2);
            ussdServiceHit3.setServiceTitle("iChooseWhen");
            ussdServiceHit3.setThemeId(1);
            ussdServiceHit3.setThemeTitle("Sex & Family Planning");
            ussdServiceHit3.setSmsId(2);
            ussdHitsStoreRepository.save(ussdServiceHit3);

            UssdServiceHit ussdServiceHit5 = new UssdServiceHit();
            ussdServiceHit5.setId("5");
            ussdServiceHit5.setUssdSessionId("5");
            ussdServiceHit5.setDate(new Date());
            ussdServiceHit5.setMsisdn("27724194158");
            ussdServiceHit5.setContentVersion(1);
            ussdServiceHit5.setThemeId(1);
            ussdServiceHit5.setThemeTitle("Sex & Family Planning");
            ussdHitsStoreRepository.save(ussdServiceHit5);

            UssdServiceHit ussdServiceHit4 = new UssdServiceHit();
            ussdServiceHit4.setId("4");
            ussdServiceHit4.setUssdSessionId("4");
            ussdServiceHit4.setDate(new Date());
            ussdServiceHit4.setMsisdn("27724194158");
            ussdServiceHit4.setContentVersion(1);
            ussdServiceHit4.setServiceId(3);
            ussdServiceHit4.setServiceTitle("BabyInfo");
            ussdServiceHit4.setThemeId(2);
            ussdServiceHit4.setThemeTitle("Pregnancy & Childcare");
            ussdHitsStoreRepository.save(ussdServiceHit4);

            UssdServiceHit ussdServiceHit6 = new UssdServiceHit();
            ussdServiceHit6.setId("6");
            ussdServiceHit6.setUssdSessionId("6");
            ussdServiceHit6.setDate(new Date());
            ussdServiceHit6.setMsisdn("27724194158");
            ussdServiceHit6.setContentVersion(1);
            ussdServiceHit6.setThemeId(2);
            ussdServiceHit6.setThemeTitle("Pregnancy & Childcare");
            ussdHitsStoreRepository.save(ussdServiceHit6);
        }

        @Test
        public void testFindTotalHitsPerService() {
            Collection<UssdServiceHitsDTO> result = ussdHitsStoreRepository.findTotalHitsPerService(yesterday, new Date());
            Assert.assertEquals(3, result.size());
            Assert.assertNotNull(result.iterator().next().getServiceHits());
        }

        @Test
        public void testFindTotalHitsPerServiceInTheme() {
            Collection<UssdServiceHitsDTO> result = ussdHitsStoreRepository.findTotalHitsPerServiceInTheme(yesterday, new Date(), 1);
            Assert.assertEquals(2, result.size());
            Assert.assertNotNull(result.iterator().next().getServiceHits());
        }

        @Test
        public void testFindTotalHitsPerTheme() {
            Collection<UssdThemeHitsDTO> result = ussdHitsStoreRepository.findTotalHitsPerTheme(yesterday, new Date());
            Assert.assertEquals(2,result.size());
            Assert.assertNotNull(result.iterator().next().getThemeHits());
        }

}

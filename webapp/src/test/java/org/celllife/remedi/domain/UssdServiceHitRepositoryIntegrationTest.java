package org.celllife.remedi.domain;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
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
            ussdServiceHit.setThemeTitle("Sex and Family Planning");
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
            ussdServiceHit2.setThemeTitle("Sex and Family Planning");
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
            ussdServiceHit3.setThemeTitle("Sex and Family Planning");
            ussdHitsStoreRepository.save(ussdServiceHit3);

            UssdServiceHit ussdServiceHit4 = new UssdServiceHit();
            ussdServiceHit4.setId("4");
            ussdServiceHit4.setUssdSessionId("4");
            ussdServiceHit4.setDate(new Date());
            ussdServiceHit4.setMsisdn("27724194158");
            ussdServiceHit4.setContentVersion(1);
            ussdServiceHit4.setServiceId(3);
            ussdServiceHit4.setServiceTitle("YoungAfricansLive");
            ussdServiceHit4.setThemeId(1);
            ussdServiceHit4.setThemeTitle("Sex and Family Planning");
            ussdHitsStoreRepository.save(ussdServiceHit4);
        }

        @Test
        public void testFindTotalHits() {
            Iterable<UssdHitsDTO> result = ussdHitsStoreRepository.findTotalHits();
            System.out.println(result);
        }


}

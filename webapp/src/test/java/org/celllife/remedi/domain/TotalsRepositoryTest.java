package org.celllife.remedi.domain;

import junit.framework.Assert;

import org.celllife.remedi.domain.datamart.TotalDTO;
import org.celllife.remedi.domain.datamart.TotalsRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
public class TotalsRepositoryTest {
	@Autowired
	TotalsRepository totalsRepository;
	
	@Ignore
	@Test
	public void testGetTotals() {
		TotalDTO totalsDTO = totalsRepository.getTotals();
	Assert.assertEquals(Long.valueOf(6), totalsDTO.getTotalVisits());
	}

}

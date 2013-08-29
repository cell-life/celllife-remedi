package org.celllife.remedi.domain.datamart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TotalsRepository extends PagingAndSortingRepository<UssdPageVisit, String> {
	
	@Query("select new org.celllife.remedi.domain.datamart.TotalDTO(count(distinct ussdSessionId)) "
			+ "from UssdPageVisit")
	
	TotalDTO getTotals();

}

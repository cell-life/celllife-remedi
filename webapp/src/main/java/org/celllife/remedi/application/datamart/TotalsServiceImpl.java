package org.celllife.remedi.application.datamart;

import org.celllife.remedi.domain.datamart.TotalDTO;
import org.celllife.remedi.domain.datamart.TotalsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TotalsServiceImpl implements TotalsService {
	@Autowired
	TotalsRepository totalsRepository;
	
	
	public TotalDTO getTotals(){
		return totalsRepository.getTotals();
	}
	
}

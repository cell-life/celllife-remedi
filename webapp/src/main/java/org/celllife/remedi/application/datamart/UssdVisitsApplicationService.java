package org.celllife.remedi.application.datamart;

import org.celllife.remedi.domain.datamart.UssdPageVisitsDTO;

import java.util.Date;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 21h59
 */
public interface UssdVisitsApplicationService {

    public List<UssdPageVisitsDTO> getUssdVisits(Date startDate, Date endDate);

}

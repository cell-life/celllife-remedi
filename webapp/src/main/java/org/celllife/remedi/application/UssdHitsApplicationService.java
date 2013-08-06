package org.celllife.remedi.application;

import org.celllife.remedi.domain.UssdAllHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitsDTO;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 21h59
 */
public interface UssdHitsApplicationService {

    public List<UssdAllHitsDTO> getUssdHits(Date startDate, Date endDate);

}

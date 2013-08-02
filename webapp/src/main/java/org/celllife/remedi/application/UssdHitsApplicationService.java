package org.celllife.remedi.application;

import org.celllife.remedi.domain.UssdHitsDTO;

import java.util.Collection;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 21h59
 */
public interface UssdHitsApplicationService {

    public Collection<UssdHitsDTO> getUssdHits(Date startDate, Date endDate);

}

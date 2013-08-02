package org.celllife.remedi.application;

import org.celllife.remedi.domain.UssdHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h57
 */
@Service
public class UssdHitsApplicationServiceImpl implements UssdHitsApplicationService {

    @Autowired
    private UssdServiceHitRepository ussdServiceHitRepository;

    public Collection<UssdHitsDTO> getUssdHits(Date startDate, Date endDate) {

        return ussdServiceHitRepository.findTotalHits();

    }

}

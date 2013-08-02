package org.celllife.remedi.application;

import org.celllife.remedi.domain.UssdAllHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitRepository;
import org.celllife.remedi.domain.UssdThemeHitsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * User: Kevin W. Sewell
 * Date: 2013-04-04
 * Time: 08h57
 */
@Service
public class UssdHitsApplicationServiceImpl implements UssdHitsApplicationService {

    @Autowired
    private UssdServiceHitRepository ussdServiceHitRepository;

    public Collection<UssdAllHitsDTO> getUssdHits(Date startDate, Date endDate) {

        Collection<UssdAllHitsDTO> ussdAllHitsDTOs = new ArrayList<UssdAllHitsDTO>();

        Collection<UssdServiceHitsDTO> ussdServiceHitsDT0s = ussdServiceHitRepository.findTotalHitsPerService(startDate,endDate);
        for (UssdServiceHitsDTO ussdServiceHitsDTO : ussdServiceHitsDT0s) {
            UssdAllHitsDTO ussdAllHitsDTO = new UssdAllHitsDTO(ussdServiceHitsDTO.getServiceId(), ussdServiceHitsDTO.getServiceTitle(), ussdServiceHitsDTO.getServiceHits(), ussdServiceHitsDTO.getSmsHits());
            ussdAllHitsDTOs.add(ussdAllHitsDTO);
        }

        Collection<UssdThemeHitsDTO> ussdThemeHitsDTOs = ussdServiceHitRepository.findTotalHitsPerTheme(startDate,endDate);
        for (UssdThemeHitsDTO ussdThemeHitsDTO : ussdThemeHitsDTOs) {
            UssdAllHitsDTO ussdAllHitsDTO = new UssdAllHitsDTO(ussdThemeHitsDTO.getThemeId(), ussdThemeHitsDTO.getThemeTitle(), ussdThemeHitsDTO.getThemeHits(), 0);
            ussdAllHitsDTOs.add(ussdAllHitsDTO);
        }

        return ussdAllHitsDTOs;

    }

}

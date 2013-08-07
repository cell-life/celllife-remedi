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

    public List<UssdAllHitsDTO> getUssdHits(Date startDate, Date endDate) {

        List<UssdAllHitsDTO> ussdAllHitsDTOs = new ArrayList<UssdAllHitsDTO>();
        Collection<UssdThemeHitsDTO> ussdThemeHitsDTOs = ussdServiceHitRepository.findTotalHitsPerTheme(startDate,endDate);
        Collection<UssdServiceHitsDTO> ussdServiceHitsDT0s;

        for (UssdThemeHitsDTO ussdThemeHitsDTO : ussdThemeHitsDTOs) {

            UssdAllHitsDTO ussdAllHitsDTO = new UssdAllHitsDTO(ussdThemeHitsDTO.getThemeId(), ussdThemeHitsDTO.getThemeTitle(), ussdThemeHitsDTO.getThemeHits(), 0, true);
            ussdAllHitsDTOs.add(ussdAllHitsDTO);

            ussdServiceHitsDT0s = ussdServiceHitRepository.findTotalHitsPerServiceInTheme(startDate,endDate,ussdThemeHitsDTO.getThemeId());
            for (UssdServiceHitsDTO ussdServiceHitsDTO : ussdServiceHitsDT0s) {
                    UssdAllHitsDTO ussdAllHitsDTO2 = new UssdAllHitsDTO(ussdServiceHitsDTO.getServiceId(), ussdServiceHitsDTO.getServiceTitle(), ussdServiceHitsDTO.getServiceHits(), ussdServiceHitsDTO.getSmsHits(), false);
                    ussdAllHitsDTOs.add(ussdAllHitsDTO2);
            }
        }

        return ussdAllHitsDTOs;

    }

}

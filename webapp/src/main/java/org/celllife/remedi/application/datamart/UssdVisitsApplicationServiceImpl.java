package org.celllife.remedi.application.datamart;

import org.celllife.remedi.domain.datamart.UssdPageVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdServiceVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdThemeVisitsDTO;
import org.celllife.remedi.domain.datamart.UssdVisitsStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UssdVisitsApplicationServiceImpl implements UssdVisitsApplicationService {

    @Autowired
    private UssdVisitsStoreRepository ussdVisitsStoreRepository;

    public List<UssdPageVisitsDTO> getUssdVisits(Date startDate, Date endDate) {

        List<UssdPageVisitsDTO> ussdPageVisitsDTOs = new ArrayList<UssdPageVisitsDTO>();
        Collection<UssdThemeVisitsDTO> ussdThemeVisitsDTOs = ussdVisitsStoreRepository.findTotalVisitsPerTheme(startDate, endDate);

        for (UssdThemeVisitsDTO ussdThemeVisitsDTO : ussdThemeVisitsDTOs) {

            UssdPageVisitsDTO ussdPageVisitsDTO = new UssdPageVisitsDTO(ussdThemeVisitsDTO.getThemeId(), ussdThemeVisitsDTO.getThemeTitle(), ussdThemeVisitsDTO.getThemeVisits(), 0, true);
            ussdPageVisitsDTOs.add(ussdPageVisitsDTO);

            Collection<UssdServiceVisitsDTO> ussdServiceVisitsDTOs = ussdVisitsStoreRepository.findTotalVisitsPerServiceInTheme(startDate, endDate, ussdThemeVisitsDTO.getThemeId());
            for (UssdServiceVisitsDTO ussdServiceVisitsDTO : ussdServiceVisitsDTOs) {
                ussdPageVisitsDTO = new UssdPageVisitsDTO(ussdServiceVisitsDTO.getServiceId(), ussdServiceVisitsDTO.getServiceTitle(), ussdServiceVisitsDTO.getServiceVisits(), ussdServiceVisitsDTO.getSmsHits(), false);
                ussdPageVisitsDTOs.add(ussdPageVisitsDTO);
            }
        }

        return ussdPageVisitsDTOs;

    }

}

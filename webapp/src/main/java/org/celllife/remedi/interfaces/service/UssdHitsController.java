package org.celllife.remedi.interfaces.service;

import org.celllife.remedi.application.UssdHitsApplicationService;
import org.celllife.remedi.domain.UssdAllHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;
import java.util.Date;

@Controller
public class UssdHitsController {

    @Autowired
    private UssdHitsApplicationService ussdHitsApplicationService;

    @ResponseBody
    @RequestMapping(
            value = "/service/ussdHits",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<UssdAllHitsDTO> findUssdHits(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return ussdHitsApplicationService.getUssdHits(startDate,endDate);

    }

}
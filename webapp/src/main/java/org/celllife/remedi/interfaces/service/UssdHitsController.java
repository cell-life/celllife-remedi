package org.celllife.remedi.interfaces.service;

import org.celllife.remedi.application.UssdHitsApplicationService;
import org.celllife.remedi.domain.UssdAllHitsDTO;
import org.celllife.remedi.domain.UssdServiceHitsDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Controller
public class UssdHitsController {

    @Autowired
    private UssdHitsApplicationService ussdHitsApplicationService;

    private static Logger log = LoggerFactory.getLogger(UssdHitsController.class);

    @ResponseBody
    @RequestMapping(
            value = "/service/ussdHits",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<UssdAllHitsDTO> findUssdHits(@RequestParam("startDate") Date startDate, @RequestParam("endDate") Date endDate) {

        return ussdHitsApplicationService.getUssdHits(startDate,endDate);

    }

    @ResponseBody
    @RequestMapping(value = "/service/ussdHits/csvFormat", method = RequestMethod.GET)
    public void getMmcHits(
            @RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate,
            HttpServletResponse response) {

        //Collection<UssdClinicLocatorDTO> results = mmcHitsService.getHits(startDate, endDate);

        String results = "test,test,test";

        response.setContentType("text/csv;charset=utf-8");
        response.setHeader("Content-Disposition","attachment; filename=\"pageviews.csv\"");

        OutputStreamWriter out = null;
        try {
            out = new OutputStreamWriter(new BufferedOutputStream(response.getOutputStream()));
            out.write(results);
        } catch (IOException e) {
            throw new RuntimeException("Could not create CSV file.", e);
        } finally {
            try {
                if (out != null) {
                    out.flush();
                    out.close();
                }
            } catch (IOException e) {
                log.warn("Ignoring IOException thrown when trying to close and flush the OutputStream during CVS creation.",e.getMessage());
            }
        }
    }
}
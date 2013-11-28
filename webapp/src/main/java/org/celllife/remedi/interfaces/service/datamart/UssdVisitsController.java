package org.celllife.remedi.interfaces.service.datamart;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.celllife.remedi.application.datamart.UssdVisitsApplicationService;
import org.celllife.remedi.domain.datamart.UssdPageVisitsDTO;
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
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

@Controller
public class UssdVisitsController {

    @Autowired
    private UssdVisitsApplicationService ussdVisitsApplicationService;

    private static Logger log = LoggerFactory.getLogger(UssdVisitsController.class);

    @ResponseBody
    @RequestMapping(
            value = "/service/ussdVisits",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Collection<UssdPageVisitsDTO> findUssdVisits(
    		@RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate, 
    		@RequestParam("endDate")  @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate) {

        return ussdVisitsApplicationService.getUssdVisits(startDate, endDate);

    }

    @ResponseBody
    @RequestMapping(value = "/service/ussdVisits/csvFormat", method = RequestMethod.GET)
    public void getVisits(
            @RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate,
            HttpServletResponse response) throws IOException {

        Calendar c = Calendar.getInstance();
        c.setTime(endDate);
        c.set(Calendar.HOUR_OF_DAY,24);
        c.set(Calendar.MINUTE,00);
        endDate = c.getTime(); // set the time to midnight

        response.setContentType("text/csv;charset=utf-8");
        response.setHeader("Content-Disposition","attachment; filename=\"pageviews.csv\"");

        ICsvBeanWriter writer = null;
        try {
            writer = new CsvBeanWriter(new OutputStreamWriter(new BufferedOutputStream(response.getOutputStream())), CsvPreference.STANDARD_PREFERENCE);

            Collection<UssdPageVisitsDTO> ussdPageVisitsDTOs = ussdVisitsApplicationService.getUssdVisits(startDate, endDate);

            final String[] header = new String[] { "themeName", "serviceName", "pageVisits", "smses" };
            final CellProcessor[] processors = getProcessors();
            writer.writeHeader(header);
            for (final UssdPageVisitsDTO ussdPageVisitsDTO : ussdPageVisitsDTOs) {
                writer.write(ussdPageVisitsDTO, header, processors);
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not create CSV file.", e);
        } finally {
            if( writer != null ) {
                writer.close();
            }

        }

    }

    private static CellProcessor[] getProcessors() {
        final CellProcessor[] processors = new CellProcessor[] {
                new Optional(),
                new Optional(),
                new Optional(),
                new Optional()
        };
        return processors;
    }
}
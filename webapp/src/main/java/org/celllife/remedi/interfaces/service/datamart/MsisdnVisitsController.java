package org.celllife.remedi.interfaces.service.datamart;

import java.util.Date;

import org.celllife.remedi.application.datamart.UssdVisitsApplicationService;
import org.celllife.remedi.domain.datamart.MsisdnVisitsPageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MsisdnVisitsController {

    @Autowired
    private UssdVisitsApplicationService ussdVisitsApplicationService;

    //private static Logger log = LoggerFactory.getLogger(MsisdnVisitsController.class);
    
    
	@ResponseBody
	@RequestMapping(value = "/service/msisdnVisits", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public MsisdnVisitsPageDTO findIndividualRatingsByClinic(
			@RequestParam("startDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date startDate, 
			@RequestParam("endDate") @DateTimeFormat(pattern="dd/MM/yyyy") Date endDate,
			@RequestParam("iDisplayStart") Integer iDisplayStart,
			@RequestParam("iDisplayLength") Integer iDisplayLength,
			@RequestParam(value="sSearch",required=false) String sSearch,
			@RequestParam(value="iSortingCols",required=false) Integer iSortingCols,
			@RequestParam(value="iSortCol_0",required=false) Integer iSortCol_0,
			@RequestParam(value="iSortCol_1",required=false) Integer iSortCol_1,
			@RequestParam(value="iSortCol_2",required=false) Integer iSortCol_2,
			@RequestParam(value="iSortCol_3",required=false) Integer iSortCol_3,
			@RequestParam(value="iSortCol_4",required=false) Integer iSortCol_4,
			@RequestParam(value="iSortCol_5",required=false) Integer iSortCol_5,
			@RequestParam(value="iSortCol_6",required=false) Integer iSortCol_6,
			@RequestParam(value="iSortCol_7",required=false) Integer iSortCol_7,
			@RequestParam(value="sSortDir_0",required=false) String sSortDir_0,
			@RequestParam(value="sSortDir_1",required=false) String sSortDir_1,
			@RequestParam(value="sSortDir_2",required=false) String sSortDir_2,
			@RequestParam(value="sSortDir_3",required=false) String sSortDir_3,
			@RequestParam(value="sSortDir_4",required=false) String sSortDir_4,
			@RequestParam(value="sSortDir_5",required=false) String sSortDir_5,
			@RequestParam(value="sSortDir_6",required=false) String sSortDir_6,
			@RequestParam(value="sSortDir_7",required=false) String sSortDir_7,
			@RequestParam(value="sEcho",required=false) String sEcho) {

		return ussdVisitsApplicationService.getMsisdnVisits(startDate, endDate,
				iDisplayStart, iDisplayLength, sSearch,
				iSortingCols,iSortCol_0,iSortCol_1,iSortCol_2,iSortCol_3,iSortCol_4,iSortCol_5,iSortCol_6,
				sSortDir_0,sSortDir_1,sSortDir_2,sSortDir_3,sSortDir_4,sSortDir_5,sSortDir_6,
				sEcho);
	}

    /*@ResponseBody
    @RequestMapping(value = "/service/msisdnVisits/csvFormat", method = RequestMethod.GET)
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
    }*/
}
package org.celllife.remedi.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import java.text.SimpleDateFormat
import java.util.Calendar;

import static org.celllife.remedi.framework.restclient.RESTClient.get

@Controller
class ReportController {

    @Value('${external.base.url}')
    def String externalBaseUrl;

    @RequestMapping("/")
    def index(Model model) {
        getUssdVisits(null, null, model)
    }

    @RequestMapping(value="/reports/ussdVisits", method = RequestMethod.GET)
    def getUssdVisits(@RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null)){
           	Calendar c = Calendar.getInstance()   // this takes current date
        	c.set(Calendar.DAY_OF_MONTH, 1)
        	c.set(Calendar.HOUR, 0)
        	c.set(Calendar.MINUTE, 0)
        	c.set(Calendar.SECOND, 0)
        	c.set(Calendar.MILLISECOND, 0)
        	sd = c.getTime()
        }
        else {
            sd = new SimpleDateFormat("dd/MM/yyyy").parse(startDate)
        }

        Date ed

        if (endDate.equals(null))
            ed = new Date()
        else {
            ed = new SimpleDateFormat("dd/MM/yyyy").parse(endDate)

            Calendar c = Calendar.getInstance()
            c.setTime(ed)
            c.set(Calendar.HOUR_OF_DAY,24)
            c.set(Calendar.MINUTE,00)
            ed = c.getTime() // set the time to midnight
        }

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        } else {
            def visits = get("${externalBaseUrl}/service/ussdVisits", [startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
            model.put("visits", visits)
            return "reports/ussdVisits";
        }
    }

}

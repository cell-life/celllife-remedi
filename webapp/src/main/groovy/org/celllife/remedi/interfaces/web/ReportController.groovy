package org.celllife.remedi.interfaces.web

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

import java.text.SimpleDateFormat

import static org.celllife.remedi.framework.restclient.RESTClient.get

@Controller
class ReportController {

    @Value('${external.base.url}')
    def String externalBaseUrl;

    @RequestMapping("/")
    def index(Model model) {
        getUssdHits(null, null, model)
    }

    @RequestMapping(value="/reports/ussdHits", method = RequestMethod.GET)
    def getUssdHits(@RequestParam(value = "startDate", required = false) String startDate, @RequestParam(value = "endDate", required = false) String endDate, Model model) {

        Date sd
        if (startDate.equals(null))
            sd = new Date(946684800) //This is Unix time for 01 Jan 2000
        else
            sd = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(startDate)

        Date ed

        if (endDate.equals(null))
            ed = new Date()
        else
            ed = new SimpleDateFormat("dd/MM/yyyy hh:mm aa").parse(endDate)

        if (sd > ed) {
            throw new Exception("Error: The \"From\" date must be earlier than the \"To\" date.")
        } else {
            //System.out.println("${external.base.url}/service/ussdHits");
            def hits = get("${externalBaseUrl}/service/ussdHits", [startDate: sd.format("MM/dd/yy hh:mm aa"), endDate: ed.format("MM/dd/yy hh:mm aa")])
            model.put("hits", hits)
            return "reports/ussdHits";
        }
    }

}

package org.celllife.remedi.interfaces.service.datamart;

import org.celllife.remedi.application.datamart.TotalsService;
import org.celllife.remedi.domain.datamart.TotalDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TotalsController {

    @Autowired
    TotalsService totalsService;

    @ResponseBody
    @RequestMapping(value = "/totalvisits", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public TotalDTO getTotals() throws Exception {
        return totalsService.getTotals();
    }

}
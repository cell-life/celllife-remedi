package org.celllife.remedi.integration.ussd;

import org.celllife.remedi.application.request.UssdRequestApplicationService;
import org.celllife.remedi.domain.ussd.Request;
import org.milyn.Smooks;
import org.milyn.payload.JavaResult;
import org.milyn.payload.StringSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.stereotype.Service;

@Service("remediUssdSubmissionMediator")
public class RemediUssdSubmissionMediator {

    public static final String HAPPY_RESULT = "{ \"RemediUssdSubmissionResponse\": { \"message\": \"Completed Successfully\" } }";

    @Autowired
    private UssdRequestApplicationService ussdRequestApplicationService;

    @Autowired
    private Smooks remediSmooks;

    public Message<String> handleRemediUssdSubmission(Message<byte[]> message) {

        //Get the data to filter
        StringSource source = new StringSource(new String(message.getPayload()));

        //Create the JavaResult, which will contain the filter result after filtering
        JavaResult result = new JavaResult();

        //Filter the data from the source, putting the result into the JavaResult
        this.remediSmooks.filterSource(source, result);

        Request request = ussdRequestApplicationService.save(result.getBean(Request.class));
        
        System.out.println("request="+request);

        return new GenericMessage<>(HAPPY_RESULT);
    }

}

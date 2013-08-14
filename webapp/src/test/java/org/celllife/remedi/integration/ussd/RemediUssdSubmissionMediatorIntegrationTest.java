package org.celllife.remedi.integration.ussd;

import junit.framework.Assert;

import org.apache.commons.io.IOUtils;
import org.celllife.remedi.test.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.Message;
import org.springframework.integration.message.GenericMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class RemediUssdSubmissionMediatorIntegrationTest {

    @Autowired
    private RemediUssdSubmissionMediator remediUssdSubmissionMediator;

    @Test
    public void testHandleCqmUssdSubmission() throws Exception {

    	String json = IOUtils.toString(ClassLoader.getSystemResourceAsStream("json/request.json"));

        final GenericMessage<byte[]> input = new GenericMessage<>(json.getBytes());

        Message<String> result = remediUssdSubmissionMediator.handleRemediUssdSubmission(input);
        Assert.assertEquals(RemediUssdSubmissionMediator.HAPPY_RESULT, result.getPayload());
    }
}

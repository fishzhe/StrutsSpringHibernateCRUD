package com.ssh1.service.impl;

import com.ssh1.service.TwilioSmsService;
import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.TwilioRestException;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Account;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fishzhe on 5/21/16.
 */
@Service
public class TwilioSmsServiceImpl implements TwilioSmsService {

    @Autowired
    private TwilioRestClient twilioRestClient;

    public void sendSMS(String to, String message) throws TwilioRestException {
        Account account = twilioRestClient.getAccount();
        MessageFactory messageFactory = account.getMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", to));
        params.add(new BasicNameValuePair("From", FROM));
        params.add(new BasicNameValuePair("Body", message));
        messageFactory.create(params);
    }
}

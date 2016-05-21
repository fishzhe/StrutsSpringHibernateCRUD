package com.ssh1.service;

import com.twilio.sdk.TwilioRestException;

/**
 * Created by fishzhe on 5/21/16.
 */
public interface TwilioSmsService extends TwilioService{

    void sendSMS(String to, String message) throws TwilioRestException;
}

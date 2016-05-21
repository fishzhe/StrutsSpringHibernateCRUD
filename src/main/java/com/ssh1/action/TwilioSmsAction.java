package com.ssh1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh1.service.TwilioSmsService;
import com.twilio.sdk.TwilioRestException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fishzhe on 5/21/16.
 */
@ParentPackage(value = "json-default")
public class TwilioSmsAction extends ActionSupport {

    private String to;
    private String message;

    @Autowired
    private TwilioSmsService twilioSmsService;

    @Action(value = "sendSms", results = {
            @Result(name = SUCCESS, type = "redirectAction", location = "listUser"),
            @Result(name = INPUT, location = "/index.jsp")
    })
    public String sendSms() {
        try {
            to = to.replaceAll("[^0-9]", "");
            twilioSmsService.sendSMS(to, message);
        } catch (TwilioRestException e) {
            e.printStackTrace(); // TODO: 5/21/16  handle exception
            return INPUT;
        }
        return SUCCESS;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

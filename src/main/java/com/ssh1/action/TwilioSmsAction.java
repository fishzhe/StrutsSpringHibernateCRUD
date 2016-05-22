package com.ssh1.action;

import com.opensymphony.xwork2.ActionSupport;
import com.ssh1.service.TwilioSmsService;
import com.twilio.sdk.TwilioRestException;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by fishzhe on 5/21/16.
 */
@ParentPackage(value = "json-default")
public class TwilioSmsAction extends ActionSupport {

    private String to;
    private String message;

    @Autowired
    private TwilioSmsService twilioSmsService;

    @Action(value = "sendSms",
            interceptorRefs = {
                    @InterceptorRef(value = "store", params = {"operationMode", "STORE"}),
                    @InterceptorRef(value = "defaultStack")
            },
            results = {
                    @Result(name = SUCCESS, type = "redirectAction", location = "listUser"),
                    @Result(name = INPUT, type="redirectAction", location = "listUser")
            }
    )
    public String sendSms() {
        try {
            twilioSmsService.sendSMS(to, message);
        } catch (TwilioRestException e) {
            e.printStackTrace(); // TODO: send error email to me.
            this.addActionError("Sorry, something is off, please contact fishzhe@gmail.com");
            return INPUT;
        }
        this.addActionMessage("Message Sent!");
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

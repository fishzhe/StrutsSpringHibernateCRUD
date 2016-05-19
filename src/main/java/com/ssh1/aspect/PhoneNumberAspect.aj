package com.ssh1.aspect;

import com.ssh1.model.User;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by fishzhe on 5/8/16.
 */
@Aspect
@Component
public class PhoneNumberAspect {

    @Pointcut(value = "execution(* com.ssh1.service.UserServiceImpl.saveUser(com.ssh1.model.User)) && args(user)")
    public void saveUser(User user) {}

    @Before("saveUser(user)")
    public void cleanUserPhoneNumber(User user) throws Throwable {
        String phoneNumber = user.getPhone();
        phoneNumber = phoneNumber.replaceAll("[^0-9]", "");
        user.setPhone(phoneNumber);
    }
}

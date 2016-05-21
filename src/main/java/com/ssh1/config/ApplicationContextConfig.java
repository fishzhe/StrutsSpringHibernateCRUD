package com.ssh1.config;

import com.ssh1.service.TwilioService;
import com.twilio.sdk.TwilioRestClient;
import org.springframework.context.annotation.*;

/**
 * Created by fishzhe on 5/7/16.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.ssh1"})
@Import(PersistenceConfig.class)
public class ApplicationContextConfig {

    @Bean
    public TwilioRestClient twilioRestClient() {
        return new TwilioRestClient(TwilioService.ACCOUNT_ID_TEST, TwilioService.ACCOUNT_TOKEN_TEST);
    }

}

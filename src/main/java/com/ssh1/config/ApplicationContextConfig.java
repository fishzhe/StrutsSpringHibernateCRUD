package com.ssh1.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by fishzhe on 5/7/16.
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.ssh1"})
public class ApplicationContextConfig {
}

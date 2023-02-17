package com.noname.jobhub.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.noname.jobhub.restapi"})
public class JobHubRestConfiguration {
}

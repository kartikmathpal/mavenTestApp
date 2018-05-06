package com.kartik.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.kartik"})
public class ApplicationContextBean {
    public ApplicationContextBean() {
    }


}

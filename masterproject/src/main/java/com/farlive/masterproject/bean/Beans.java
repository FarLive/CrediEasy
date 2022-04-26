package com.farlive.masterproject.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Beans {
    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

package com.farlive.masterproject.bean;

import com.farlive.masterproject.util.ServiceConsumer;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Beans {
    
    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public ServiceConsumer consumer() {
        return new ServiceConsumer();
    }

}

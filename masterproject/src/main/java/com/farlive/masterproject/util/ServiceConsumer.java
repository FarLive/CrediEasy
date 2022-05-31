package com.farlive.masterproject.util;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class ServiceConsumer {

    private final String baseUrl = "http://localhost:8080/api/";

    @Autowired
    private RestTemplate restTemplate;   

    public <T> T getForObject(Class<T> entityClass, String url) {
        return restTemplate.getForObject(baseUrl + url, entityClass);
    }

    public <T> T [] getForObjects(Class<T[]> entityClass, String url) {
        return restTemplate.getForObject(baseUrl + url, entityClass);
    }

    public <T> HttpStatus postMethod(T entity, String url) {
        try {
            return restTemplate.postForEntity(new URI(baseUrl + url), entity, entity.getClass()).getStatusCode();
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return HttpStatus.BAD_GATEWAY;
    }

    public <T> T postMethod(Class<T> entityClass, String url, String request) {
        try {
            return restTemplate.postForObject(new URI(baseUrl + url), request, entityClass);
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }
}
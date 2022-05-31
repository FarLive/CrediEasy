package com.farlive.masterproject.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.entidades.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {
   
    private final String baseUrl = "http://localhost:8080/api/customers/";

    @Autowired
    private RestTemplate restTemplate;
    
    public List<Customer> getAllCustomers(){
        Customer[] customers =
            restTemplate.getForObject(baseUrl, Customer[].class);
        return Arrays.asList(customers);
    }

    public boolean existeUsuario(String username, String password) {
        for(Customer cliente: getAllCustomers()){
            User user = cliente.getPerson().getUser();
            if(user.getEmail().equals(username) && user.getPassword().equals(password)){
                return true;
            }     
        }
        return false;
    }

    public boolean save(Customer cliente) {
        ResponseEntity<String> response;
        try {
            response = restTemplate.postForEntity(new URI(baseUrl), cliente, String.class);
            return response.getStatusCode().equals(HttpStatus.CREATED);
        } catch (RestClientException | URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean findByUsuario(String usuario) {
        return getAllCustomers().stream().anyMatch(customer -> customer.getPerson().getUser().getEmail().equals(usuario));
    }
}

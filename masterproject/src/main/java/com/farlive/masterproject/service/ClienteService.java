package com.farlive.masterproject.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import com.farlive.masterproject.entidades.Cliente;

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
    
    public List<Cliente> getAllCustomers(){
        Cliente[] customers =
            restTemplate.getForObject(baseUrl, Cliente[].class);
        return Arrays.asList(customers);
    }

    public boolean existeUsuario(String username, String password) {
        for(Cliente cliente: getAllCustomers()){
            if(cliente.getUsuario().equals(username) && cliente.getContrasena().equals(password)){
                return true;
            }     
        }
        return false;
    }

    public boolean save(Cliente cliente) {
        System.out.println("ClienteService.save() = " + cliente);
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
        return getAllCustomers().stream().anyMatch(customer -> customer.getUsuario().equals(usuario));
    }
}

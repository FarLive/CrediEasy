package com.farlive.masterproject.service;

import java.util.Arrays;
import java.util.List;

import com.farlive.masterproject.APIRESTful.repositories.ClienteRepository;
import com.farlive.masterproject.entidades.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ClienteService {
    @Autowired      // Autoinyectable
    private ClienteRepository clienteRepository;

    @Autowired
    private RestTemplate restTemplate;
    
    public List<Cliente> getAllCustomers(){
        Cliente[] customers =
            restTemplate.getForObject("http://localhost:8080/api/customers/", Cliente[].class);
        return Arrays.asList(customers);
    }

    public boolean existeUsuario(String username, String password) {
        for(Cliente cliente:clienteRepository.findAll()){
            if(cliente.getUsuario().equals(username) && cliente.getContrasena().equals(password)){
                return true;
            }     
        }
        return false;
    }
}

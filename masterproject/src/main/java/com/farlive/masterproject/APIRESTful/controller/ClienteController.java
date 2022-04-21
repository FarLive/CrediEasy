package com.farlive.masterproject.APIRESTful.controller;

import java.util.List;

import com.farlive.masterproject.APIRESTful.repositories.ClienteRepository;
import com.farlive.masterproject.entidades.Cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ClienteController {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @GetMapping("/customers")
    public List<Cliente> getAllCustomers(){
        return clienteRepository.findAll();
    }

    @PostMapping("/customers")
    public ResponseEntity<String> saveCustomer(@RequestBody Cliente cliente) {
        if(clienteRepository.save(cliente) != null) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}

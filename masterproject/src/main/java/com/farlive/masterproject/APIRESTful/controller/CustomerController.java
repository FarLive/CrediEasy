package com.farlive.masterproject.APIRESTful.controller;

import java.util.List;

import com.farlive.masterproject.APIRESTful.repositories.CustomerRepository;
import com.farlive.masterproject.entidades.Customer;

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
public class CustomerController {
    
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    @PostMapping("/save-customers")
    public ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return customerRepository.save(customer) != null ? new ResponseEntity<>(HttpStatus.OK)
                                                         : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/remove-customer")
    public void remove(@RequestBody Customer customer) {
        customerRepository.delete(customer);
    }

}
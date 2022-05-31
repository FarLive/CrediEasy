package com.farlive.masterproject.service.service;

import java.util.List;

import com.farlive.masterproject.entidades.Customer;

public interface CustomerService {
    
    public abstract boolean save(Customer customer);

    public List<Customer> getAll();

    public Customer findByUser(String user);

}

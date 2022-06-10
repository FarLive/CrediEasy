package com.farlive.masterproject.service.service;

import java.util.List;

import com.farlive.masterproject.entidades.Customer;

public interface CustomerService {
    
    public abstract boolean save(Customer customer);

    public abstract void remove(Customer customer);

    public abstract List<Customer> getAll();

    public abstract Customer findByUser(String user);

}

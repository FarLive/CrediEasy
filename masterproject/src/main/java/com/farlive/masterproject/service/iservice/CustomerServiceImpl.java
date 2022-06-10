package com.farlive.masterproject.service.iservice;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import com.farlive.masterproject.entidades.Customer;
import com.farlive.masterproject.service.service.CustomerService;
import com.farlive.masterproject.util.ServiceConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private ServiceConsumer serviceConsumer;

    @Override
    public List<Customer> getAll() {
        return Arrays.asList(serviceConsumer.getForObjects(Customer[].class, "customers"));
    }

    @Override
    @Transactional
    public boolean save(Customer customer) {
        System.out.println("CustomerServiceImpl.save() " + customer);
        return serviceConsumer.postMethod(customer, "save-customers").equals(HttpStatus.OK);
    }

    @Override
    public Customer findByUser(String username) {
        return getAll().stream()
                       .filter(customer -> customer.getPerson().getUser().getUsername().equals(username))
                       .findAny().orElse(null);
    }

    @Override
    public void remove(Customer customer) {
        serviceConsumer.postMethod(customer, "remove-customer");
    }   
}
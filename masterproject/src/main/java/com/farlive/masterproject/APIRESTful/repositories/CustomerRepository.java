package com.farlive.masterproject.APIRESTful.repositories;

import com.farlive.masterproject.entidades.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    
}

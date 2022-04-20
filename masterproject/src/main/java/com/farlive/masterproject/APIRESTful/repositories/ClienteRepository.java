package com.farlive.masterproject.APIRESTful.repositories;

import com.farlive.masterproject.entidades.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente,Integer>{
    
}

package com.farlive.masterproject.repository;

import com.farlive.masterproject.entidades.Admin;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    
}

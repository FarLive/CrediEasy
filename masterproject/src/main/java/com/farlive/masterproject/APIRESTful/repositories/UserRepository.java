package com.farlive.masterproject.APIRESTful.repositories;

import com.farlive.masterproject.entidades.User;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
    
    public abstract User findByUsername(String username);

}

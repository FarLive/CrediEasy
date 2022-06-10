package com.farlive.masterproject.APIRESTful.controller;

import java.util.List;

import com.farlive.masterproject.APIRESTful.repositories.UserRepository;
import com.farlive.masterproject.entidades.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @GetMapping("/find/{username}")
    public User findByUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }
}
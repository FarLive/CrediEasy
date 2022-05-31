package com.farlive.masterproject.service.service;

import java.util.List;

import com.farlive.masterproject.entidades.User;

public interface UserService {
    
    public abstract User findByUsername(String username);

    public abstract List<User> getAll();

}

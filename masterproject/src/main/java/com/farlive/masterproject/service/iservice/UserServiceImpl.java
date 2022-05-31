package com.farlive.masterproject.service.iservice;

import java.util.Arrays;
import java.util.List;

import com.farlive.masterproject.entidades.User;
import com.farlive.masterproject.service.service.UserService;
import com.farlive.masterproject.util.ServiceConsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ServiceConsumer serviceConsumer;

    @Override
    public User findByUsername(String username) {
        return getAll().stream().filter(user -> user.getUsername().equals(username)).findFirst().orElse(null);
    }

    @Override
    public List<User> getAll() {
        return Arrays.asList(serviceConsumer.getForObject(User[].class, "users"));
    }

}

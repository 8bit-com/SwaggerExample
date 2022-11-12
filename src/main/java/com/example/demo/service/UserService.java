package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll ();
    User getById(long id);
    void save(User user);
    void deleteById(long id);
    User findByUsername(String username);
    void addDefaultUser();
    void update(User user);
}

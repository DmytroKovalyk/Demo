package com.example.demo.service;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {
    User save(User user);

    void deleteById(String id);

    User findById(String id);

    Iterable<User> findAll();

    List<User> findByFirstName(String firstName);
}

package com.example.demo.dao;

import com.example.demo.model.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface UserRepository extends ElasticsearchRepository<User, String> {
    List<User> findByFirstName(String firstName);
}

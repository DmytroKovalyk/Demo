package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.exception.EntityNotFoundException;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    public static final String USER_NOT_FOUND_BY_ID_EXCEPTION_MESSAGE = "User with id = %s is not found";

    private final UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findById(String id) {
        Optional<User> optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new EntityNotFoundException(String.format(USER_NOT_FOUND_BY_ID_EXCEPTION_MESSAGE, id));
        }
        return optional.get();
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findByFirstName(String firstName) {
        return userRepository.findByFirstName(firstName);
    }
}

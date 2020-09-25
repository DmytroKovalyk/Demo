package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = UserController.URL_MAPPING)
public class UserController {
    protected static final String URL_MAPPING = "/api/v1/users";
    protected static final String ID_URL_MAPPING = "/{id}";

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.save(new User(userDto)));
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }


    @GetMapping(ID_URL_MAPPING)
    public ResponseEntity<User> getById(@PathVariable String id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(ID_URL_MAPPING)
    public ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody UserDto userDto) {
        User user = new User(userDto);
        user.setId(id);
        return ResponseEntity.ok(userService.save(user));
    }

    @DeleteMapping(ID_URL_MAPPING)
    public void deleteUser(@PathVariable String id) {
        userService.deleteById(id);
    }

}

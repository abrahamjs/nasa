package com.zweet.social.controller;

import com.zweet.social.dao.UserRepository;
import com.zweet.social.exception.NotFoundException;
import com.zweet.social.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

    @PostMapping//Another way to set the Rest API Post mapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User getUserById(@PathVariable Long id) {
        User  user = userRepository.findById(id).orElse(null);
        if(user == null)
            throw new NotFoundException("Not invoice item could be retrieved customer wiht id " + id);

        return user;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        userRepository.findAll().forEach(user ->{userList.add(user);});
        if(userList.isEmpty())
            throw new NotFoundException("Not users could be retrieved. ");

        return userList;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateUser(@PathVariable Long id, @RequestBody User user) {
        if(user.getId() == 0)
            user.setId(id);
        if(user.getId() != id)
            throw new IllegalArgumentException("User ID on path must match the ID in the User object");

        userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id) {
        User  user = userRepository.findById(id).orElse(null);
        if(user == null)
            throw new IllegalArgumentException("User ID not valid");
        userRepository.delete(user);
    }


}


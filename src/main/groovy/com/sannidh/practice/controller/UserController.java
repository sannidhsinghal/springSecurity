package com.sannidh.practice.controller;


import com.sannidh.practice.domain.api.UserApi;
import com.sannidh.practice.domain.dto.User;
import com.sannidh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.token.Token;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/practice/facade/users")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;


    @PreAuthorize("isAuthenticated()")
    @Override
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @Override
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @Override
    public User login(@RequestParam String name, @RequestParam String password){
        return userService.login(name,password);
    }
}

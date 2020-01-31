package com.sannidh.practice.controller;


import com.sannidh.practice.domain.api.UserApi;
import com.sannidh.practice.domain.dto.UserDTO;
import com.sannidh.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/practice/facade/users")
public class UserController implements UserApi {

    @Autowired
    private UserService userService;


    @Override
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @Override
    public UserDTO createUser(@RequestBody UserDTO userDTO){
        return userService.createUser(userDTO);
    }

    @Override
    public UserDTO login(@RequestParam String name, @RequestParam String password){
        return userService.login(name,password);
    }
}

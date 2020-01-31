package com.sannidh.practice.service;


import com.sannidh.practice.domain.dto.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();

    User createUser(User user);

    User login(String name , String password);

}

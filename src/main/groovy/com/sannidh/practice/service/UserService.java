package com.sannidh.practice.service;


import com.sannidh.practice.domain.dto.User;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User createUser(User userDTO);

    User login(String name , String password);

}

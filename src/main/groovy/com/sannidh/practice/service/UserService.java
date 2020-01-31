package com.sannidh.practice.service;


import com.sannidh.practice.domain.dto.UserDTO;

import java.util.List;

public interface UserService {


    List<UserDTO> getAllUsers();

    UserDTO createUser(UserDTO userDTO);

    UserDTO login(String name , String password);

}

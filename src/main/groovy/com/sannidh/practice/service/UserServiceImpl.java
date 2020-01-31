package com.sannidh.practice.service;


import com.sannidh.practice.domain.dto.UserDTO;
import com.sannidh.practice.entity.UserEntity;
import com.sannidh.practice.exception.UnProccesableException;
import com.sannidh.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService{

   @Autowired
    private UserRepository userRepository;

   @Autowired
   private ModelMapper modelMapper;


   @Override
    public List<UserDTO> getAllUsers(){
     return userRepository.findAll().stream().map(value ->modelMapper.map(value, UserDTO.class)).collect(Collectors.toList());
   }

   @Override
   public UserDTO createUser(UserDTO userDTO){
       UserEntity userEntity = modelMapper.map(userDTO,UserEntity.class);
       userRepository.save(userEntity);
       return modelMapper.map(userEntity, UserDTO.class);
   }


   @Override
   public UserDTO login(String name , String password){
      UserEntity userEntity = userRepository.findByUsername(name);
      if(userEntity ==null){
          throw new UnProccesableException("Username or password is incorrect");
      }
      return modelMapper.map(userEntity, UserDTO.class);
   }
}

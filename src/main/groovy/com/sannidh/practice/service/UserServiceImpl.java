package com.sannidh.practice.service;


import com.sannidh.practice.domain.dto.User;
import com.sannidh.practice.entity.UserEntity;
import com.sannidh.practice.exception.UnProccesableException;
import com.sannidh.practice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class UserServiceImpl implements UserService {

   @Autowired
   private UserRepository userRepository;

   @Autowired
   private ModelMapper modelMapper;

   @Autowired
   private BCryptPasswordEncoder bCryptPasswordEncoder;


   @Override
   public List<User> getAllUsers(){
     return userRepository.findAll().stream().map(value ->modelMapper.map(value, User.class)).collect(Collectors.toList());
   }

   @Override
   public User createUser(User user){
       UserEntity userEntity = modelMapper.map(user,UserEntity.class);
       userEntity.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
       userRepository.save(userEntity);
       return modelMapper.map(userEntity, User.class);
   }


    @Override
   public User login(String name , String password){
      Optional<UserEntity> optionalEntity = userRepository.findByUsername(name);
      if(!optionalEntity.isPresent()){
          throw new UnProccesableException("Username or password is incorrect");
      }
      UserEntity userEntity = optionalEntity.get();
      return modelMapper.map(userEntity,User.class);
   }
}
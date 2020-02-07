package com.sannidh.practice.service;


import org.springframework.security.core.userdetails.User;
import com.sannidh.practice.entity.UserEntity;
import com.sannidh.practice.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);
        optionalUser.orElseThrow(()->new UsernameNotFoundException("Username or password is incorrect"));
        UserEntity userEntity= optionalUser.get();
        GrantedAuthority authority = new SimpleGrantedAuthority("ADMIN");
        return new User(userEntity.getUsername(),userEntity.getPassword(), Arrays.asList(authority));
    }
}

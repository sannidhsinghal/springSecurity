package com.sannidh.practice.domain.api

import com.sannidh.practice.domain.dto.User
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.AuthorizationScope
import org.springframework.http.HttpStatus
import org.springframework.security.core.token.Token
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus

interface UserApi {

    @RequestMapping(value = '/getAllUsers',method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "getAllUsers" , notes ="Get information of all users",response = User.class)
    List<User> getAllUsers()

    @RequestMapping(value = '/createUser',method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "createUser" ,notes ="Add a user",response = User.class)
    User createUser(@RequestBody User user)

    @RequestMapping(value = '/login',method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "login",notes="Login for user",response = User.class)
    User login(@RequestParam String name, @RequestParam String password)

}
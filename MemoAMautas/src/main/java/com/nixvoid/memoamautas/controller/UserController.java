package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;

@RestController
@RequestMapping(value = "/core", consumes = "application/json;charset=utf-8")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/login")
    public LoginResponse loginUser(@RequestBody LoginRequest loginRequest){
        return userService.loginUser(loginRequest);
    }

    @PostMapping(value = "/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUser(@RequestBody RegisterRequest registerRequest){
        return userService.registerUser(registerRequest);
    }

    @PostMapping(value = "/forgot")
    public LoginRequest forgotPassword(@RequestBody LoginRequest request){
        return userService.ForgetPassword(request);
    }
}

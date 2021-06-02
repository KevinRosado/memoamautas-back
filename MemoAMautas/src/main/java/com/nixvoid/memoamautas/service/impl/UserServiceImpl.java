package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.repository.UserRepository;
import com.nixvoid.memoamautas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        RegisterResponse response = this.userRepository.registerPerson(registerRequest);
        Integer personCode = 0;
        if(response.getRegistered()){
            personCode = this.userRepository.getPersonInfo(registerRequest.getEmail());
        }
        return this.userRepository.registerUsuario(registerRequest, personCode);
    }
    @Override
    public Boolean verifyUserExists(String username) {
        UserDetails userDetailsOptional = this.userRepository.getUserInfo(username);
        Boolean userExists = false;
        if (userDetailsOptional == null){
            userExists = true;
        }
        return userExists;
    }
    @Override
    public LoginRequest ForgetPassword(LoginRequest loginRequest) {
        return this.userRepository.ForgetPassword(loginRequest);
    }
    @Override
    public UserDetails getDetailsFromContext() {
        SecurityContext context = SecurityContextHolder.getContext();
        return (UserDetails) context.getAuthentication().getPrincipal();
    }
}

package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.repository.UserRepository;
import com.nixvoid.memoamautas.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public RegisterResponse registerUser(RegisterRequest registerRequest) {
        return this.userRepository.registerUsuario(registerRequest);
    }

    @Override
    public LoginResponse loginUser(LoginRequest loginRequest) {
        return this.userRepository.loginUsuario(loginRequest);
    }

    @Override
    public LoginRequest ForgetPassword(LoginRequest loginRequest) {
        return this.userRepository.ForgetPassword(loginRequest);
    }

}

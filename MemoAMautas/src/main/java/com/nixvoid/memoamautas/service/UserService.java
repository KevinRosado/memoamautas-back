package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;


public interface UserService {
        RegisterResponse registerUser(RegisterRequest registerRequest);
        LoginResponse loginUser(LoginRequest loginRequest);
        LoginRequest ForgetPassword(LoginRequest loginRequest);
}

package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import org.springframework.security.core.userdetails.UserDetails;


public interface UserService {
        RegisterResponse registerUser(RegisterRequest registerRequest);
        Boolean verifyUserExists(String username);
        LoginRequest ForgetPassword(LoginRequest loginRequest);
        UserDetails getDetailsFromContext();
}

package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;

public interface UserRepository {
    LoginResponse loginUsuario(LoginRequest loginRequest);
    RegisterResponse registerUsuario(RegisterRequest registerRequest);
    LoginRequest ForgetPassword(LoginRequest loginRequest);
}

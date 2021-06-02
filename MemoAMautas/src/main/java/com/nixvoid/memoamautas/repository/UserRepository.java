package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.domain.UserDetailsImpl;
import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;

public interface UserRepository {
    RegisterResponse registerPerson(RegisterRequest registerRequest);
    RegisterResponse registerUsuario(RegisterRequest registerRequest, Integer personCode);
    LoginRequest ForgetPassword(LoginRequest loginRequest);
    UserDetailsImpl getUserInfo(String username);
    Integer getPersonInfo(String email);
}

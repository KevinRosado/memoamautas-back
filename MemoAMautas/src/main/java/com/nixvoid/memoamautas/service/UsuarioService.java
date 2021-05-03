package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;


public interface UsuarioService {
        RegisterResponse registerUsuario(RegisterRequest registerRequest);
        LoginResponse loginUsuario(LoginRequest loginRequest);
        LoginRequest ForgetPassword(LoginRequest loginRequest);
}

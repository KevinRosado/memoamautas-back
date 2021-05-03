package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.dto.LoginRequest;
import com.nixvoid.memoamautas.dto.LoginResponse;
import com.nixvoid.memoamautas.dto.RegisterRequest;
import com.nixvoid.memoamautas.dto.RegisterResponse;

public interface UsuarioRepository {
    LoginResponse loginUsuario(LoginRequest loginRequest);
    RegisterResponse registerUsuario(RegisterRequest registerRequest);
}

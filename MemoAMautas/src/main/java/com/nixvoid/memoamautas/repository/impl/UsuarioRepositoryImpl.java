package com.nixvoid.memoamautas.repository.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nixvoid.memoamautas.dto.LoginRequest;
import com.nixvoid.memoamautas.dto.LoginResponse;
import com.nixvoid.memoamautas.dto.RegisterRequest;
import com.nixvoid.memoamautas.dto.RegisterResponse;
import com.nixvoid.memoamautas.repository.UsuarioRepository;

@Repository
@Transactional
public class UsuarioRepositoryImpl implements UsuarioRepository {

    @Override
    public LoginResponse loginUsuario(LoginRequest loginRequest) {
        LoginResponse loginResponse = new LoginResponse();
        return loginResponse;
    }

    @Override
    public RegisterResponse registerUsuario(RegisterRequest registerRequest) {
        RegisterResponse registerResponse = new RegisterResponse();
        return registerResponse;
    }
}

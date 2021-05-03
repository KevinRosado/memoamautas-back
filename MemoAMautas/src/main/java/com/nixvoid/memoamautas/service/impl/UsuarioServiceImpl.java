package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;
import com.nixvoid.memoamautas.repository.UsuarioRepository;
import com.nixvoid.memoamautas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public RegisterResponse registerUsuario(RegisterRequest registerRequest) {
        return this.usuarioRepository.registerUsuario(registerRequest);
    }

    @Override
    public LoginResponse loginUsuario(LoginRequest loginRequest) {
        return this.usuarioRepository.loginUsuario(loginRequest);
    }

    @Override
    public LoginRequest ForgetPassword(LoginRequest loginRequest) {
        return this.usuarioRepository.ForgetPassword(loginRequest);
    }

}

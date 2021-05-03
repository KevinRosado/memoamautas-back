package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.LoginRequest;
import com.nixvoid.memoamautas.dto.LoginResponse;
import com.nixvoid.memoamautas.dto.RegisterRequest;
import com.nixvoid.memoamautas.dto.RegisterResponse;
import com.nixvoid.memoamautas.repository.UsuarioRepository;
import com.nixvoid.memoamautas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.uni.edu.MemoAMautas.dto.*;

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

}

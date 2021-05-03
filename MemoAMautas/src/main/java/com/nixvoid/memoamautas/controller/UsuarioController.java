package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.LoginRequest;
import com.nixvoid.memoamautas.dto.LoginResponse;
import com.nixvoid.memoamautas.dto.RegisterRequest;
import com.nixvoid.memoamautas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.nixvoid.memoamautas.dto.RegisterResponse;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public LoginResponse loginUsuario(@RequestBody LoginRequest loginRequest){
        return usuarioService.loginUsuario(loginRequest);
    }

    @PostMapping("/register")
    public RegisterResponse registerUsuario(@RequestBody RegisterRequest registerRequest){
        return usuarioService.registerUsuario(registerRequest);
    }

}

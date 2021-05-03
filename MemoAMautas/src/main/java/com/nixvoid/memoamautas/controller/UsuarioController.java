package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.access.LoginRequest;
import com.nixvoid.memoamautas.dto.access.LoginResponse;
import com.nixvoid.memoamautas.dto.access.RegisterRequest;
import com.nixvoid.memoamautas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.nixvoid.memoamautas.dto.access.RegisterResponse;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public LoginResponse loginUsuario(@RequestBody LoginRequest loginRequest){
        return usuarioService.loginUsuario(loginRequest);
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUsuario(@RequestBody RegisterRequest registerRequest){
        return usuarioService.registerUsuario(registerRequest);
    }

    @PostMapping
    public LoginRequest forgotPassword(@RequestBody LoginRequest request){
        return usuarioService.ForgetPassword(request);
    }
}

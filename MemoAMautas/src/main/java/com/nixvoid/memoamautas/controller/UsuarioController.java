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
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public LoginResponse loginUsuario(@RequestBody LoginRequest loginRequest){
        return usuarioService.loginUsuario(loginRequest);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse registerUsuario(@RequestBody RegisterRequest registerRequest){
        return usuarioService.registerUsuario(registerRequest);
    }

    @RequestMapping(value = "/forgot", method = RequestMethod.POST,consumes = "application/json;charset=utf-8")
    public LoginRequest forgotPassword(@RequestBody LoginRequest request){
        return usuarioService.ForgetPassword(request);
    }
}

package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.LoginRequest;
import com.nixvoid.memoamautas.dto.LoginResponse;
import com.nixvoid.memoamautas.dto.RegisterRequest;
import com.nixvoid.memoamautas.dto.RegisterResponse;
import pe.uni.edu.MemoAMautas.dto.*;

public interface UsuarioService {
        RegisterResponse registerUsuario(RegisterRequest registerRequest);
        LoginResponse loginUsuario(LoginRequest loginRequest);
}

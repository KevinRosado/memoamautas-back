package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

@Data
public class LoginRequest {
    private String usuario;
    private String password;
}

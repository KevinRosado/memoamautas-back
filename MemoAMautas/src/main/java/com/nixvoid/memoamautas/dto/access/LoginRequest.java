package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}

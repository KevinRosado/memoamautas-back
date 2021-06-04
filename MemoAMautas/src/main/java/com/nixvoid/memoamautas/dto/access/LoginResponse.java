package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

import java.util.List;

@Data
public class LoginResponse {
    private String username;
    private String email;
    private String jwt;
    private String expiresIn;
    private List<String> roles;
}

package com.nixvoid.memoamautas.dto.access;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class LoginResponse {
    private UserDetails details;
    private String jwt;
}

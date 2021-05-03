package com.nixvoid.memoamautas.dto;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class LoginResponse {
    private UserDetails userDetails;
    private String jwtoken;
}

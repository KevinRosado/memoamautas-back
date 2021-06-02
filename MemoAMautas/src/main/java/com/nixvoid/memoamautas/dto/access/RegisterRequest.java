package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

@Data
public class RegisterRequest {
    private String name;
    private String first_surname;
    private String second_surname;
    private String birthday;
    private String email;
    private String username;
    private String password;
    private String role;
}

package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

import java.util.Date;

@Data
public class LoginResponse {
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private Date fecha_nac;
    private String rol;
    private String username;
    private String password;
}

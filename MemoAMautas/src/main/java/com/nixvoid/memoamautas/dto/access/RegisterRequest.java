package com.nixvoid.memoamautas.dto.access;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterRequest {
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private Date fecha_nac;
    private String username;
    private String password;
    private String rol;
}

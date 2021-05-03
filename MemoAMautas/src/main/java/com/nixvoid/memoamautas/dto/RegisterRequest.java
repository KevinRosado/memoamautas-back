package com.nixvoid.memoamautas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterRequest {
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private Date fecha_nac;
    private String alias;
    private String rol;
}

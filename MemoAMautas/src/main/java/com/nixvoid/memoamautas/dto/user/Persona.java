package com.nixvoid.memoamautas.dto.user;


import lombok.Data;

import java.util.Date;

@Data
public class Persona {
    private String nombre;
    private String ape_pat;
    private String ape_mat;
    private Date fecha_nac;
    private String rol;

}
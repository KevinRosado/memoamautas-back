package com.nixvoid.memoamautas.dto.courses;

import lombok.Data;

@Data
public class Curso {
    private String id;
    private String nombre;
    private Integer creditos;
    private String cod_materia;
}

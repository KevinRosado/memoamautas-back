package com.nixvoid.memoamautas.dto.courses;

import lombok.Data;

import java.util.List;

@Data
public class Curso {
    private String id;
    private String nombre;
    private Integer creditos;
    private List<Modulo> modulos;
}

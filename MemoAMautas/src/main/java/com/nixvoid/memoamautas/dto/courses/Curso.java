package com.nixvoid.memoamautas.dto.courses;

import com.nixvoid.memoamautas.dto.user.Persona;
import lombok.Data;

import java.util.List;

@Data
public class Curso {
    private String id;
    private String nombre;
    private Integer creditos;
    private String descripcion;
    private List<Persona> profesores;
    private List<Modulo> modulos;
}

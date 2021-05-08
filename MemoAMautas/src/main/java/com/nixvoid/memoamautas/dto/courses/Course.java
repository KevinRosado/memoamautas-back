package com.nixvoid.memoamautas.dto.courses;

import com.nixvoid.memoamautas.dto.user.Person;
import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String id;
    private String nombre;
    private Integer creditos;
    private String descripcion;
    private List<Person> profesores;
    private List<Module> modules;
}

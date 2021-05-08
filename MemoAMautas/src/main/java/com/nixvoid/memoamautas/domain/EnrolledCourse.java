package com.nixvoid.memoamautas.domain;

import lombok.Data;

import java.util.Date;

@Data
public class EnrolledCourse {
    private Integer id_matriculado;
    private String id_curso;
    private String nombre_curso;
    private String id_persona;
    private Date fecha_inscripcion;
    private Integer progreso_curso;
}

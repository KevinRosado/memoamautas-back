package com.nixvoid.memoamautas.dto;

import lombok.Data;

import java.util.Date;

@Data
public class CursoMatriculado {
    private String id_matriculado;
    private String id_curso;
    private String id_persona;
    private Date fecha_inscripcion;
    private Integer progreso_curso;
}

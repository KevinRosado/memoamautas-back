package com.nixvoid.memoamautas.domain;

import com.nixvoid.memoamautas.dto.courses.Curso;
import lombok.Data;

import java.util.List;

@Data
public class CursoEtiquetado {
    private String tipo_etiqueta;
    private String valor_etiqueta;
    private List<Curso> cursos;
}

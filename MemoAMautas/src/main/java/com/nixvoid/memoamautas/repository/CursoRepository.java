package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.domain.CursoMatriculado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;

public interface CursoRepository {
    CursoEtiquetado obtenerCursos(Etiqueta etiqueta);
    Curso obtenerCursoDetails(Curso curso);
    Curso inscribirCurso(CursoMatriculado cursoMatriculado);
    Curso obtenerInfo(Curso curso);
}

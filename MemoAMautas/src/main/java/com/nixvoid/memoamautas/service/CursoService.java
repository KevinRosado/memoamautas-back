package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.domain.CursoMatriculado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.dto.courses.Modulo;

public interface CursoService {
    CursoEtiquetado obtenerCursos(Etiqueta etiqueta);
    Curso obtenerCursoDetails(Curso curso);
    Modulo obtenerSesiones(Modulo modulo);
    Curso inscribirCurso(CursoMatriculado cursoMatriculado);
    Curso obtenerInfo(Curso curso);
}

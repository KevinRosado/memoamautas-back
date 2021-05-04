package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;

import java.util.List;

public interface CursoRepository {
    CursoEtiquetado obtenerCursos(Etiqueta etiqueta);
    Curso obtenerCursoDetails(Curso curso);
    Modulo obtenerSesiones(Modulo modulo);
}

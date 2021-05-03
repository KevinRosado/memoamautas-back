package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;

import java.util.List;

public interface CursoRepository {
    List<Curso> obtenerCurso(Curso curso);
    List<Modulo> obtenerModulo(Curso curso);
    List<Sesion> obtenerSesion(Curso curso);
}

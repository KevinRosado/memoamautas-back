package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.dto.Curso;
import com.nixvoid.memoamautas.dto.Modulo;
import com.nixvoid.memoamautas.dto.Sesion;

import java.util.List;

public interface CursoRepository {
    List<Curso> obtenerCurso(Curso curso);
    List<Modulo> obtenerModulo(Curso curso);
    List<Sesion> obtenerSesion(Curso curso);
}

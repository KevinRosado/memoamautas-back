package com.nixvoid.memoamautas.repository.impl;

import com.nixvoid.memoamautas.dto.Curso;
import com.nixvoid.memoamautas.repository.CursoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.nixvoid.memoamautas.dto.Modulo;
import com.nixvoid.memoamautas.dto.Sesion;

import java.util.List;

@Repository
@Transactional
public class CursoRepositoryImpl implements CursoRepository {

    @Override
    public List<Curso> obtenerCurso(Curso curso) {
        return null;
    }

    @Override
    public List<Modulo> obtenerModulo(Curso curso) {
        return null;
    }

    @Override
    public List<Sesion> obtenerSesion(Curso curso) {
        return null;
    }
}

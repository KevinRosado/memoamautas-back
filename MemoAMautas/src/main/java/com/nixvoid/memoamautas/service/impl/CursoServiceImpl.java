package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.Curso;
import com.nixvoid.memoamautas.dto.Modulo;
import com.nixvoid.memoamautas.dto.Sesion;
import com.nixvoid.memoamautas.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.nixvoid.memoamautas.service.CursoService;

import java.util.List;

@Service
@Transactional
public class CursoServiceImpl implements CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Override
    public List<Curso> obtenerCurso(Curso curso) {
        return cursoRepository.obtenerCurso(curso);
    }

    @Override
    public List<Modulo> obtenerModulo(Curso curso) {
        return cursoRepository.obtenerModulo(curso);
    }

    @Override
    public List<Sesion> obtenerSesion(Curso curso) {
        return cursoRepository.obtenerSesion(curso);
    }
}

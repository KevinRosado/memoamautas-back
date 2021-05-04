package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;
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
    public CursoEtiquetado obtenerCursos(Etiqueta etiqueta) {
        return cursoRepository.obtenerCursos(etiqueta);
    }

    @Override
    public Curso obtenerCursoDetails(Curso curso) {
        return cursoRepository.obtenerCursoDetails(curso);
    }

    @Override
    public Modulo obtenerSesiones(Modulo modulo) {
        return cursoRepository.obtenerSesiones(modulo);
    }
}

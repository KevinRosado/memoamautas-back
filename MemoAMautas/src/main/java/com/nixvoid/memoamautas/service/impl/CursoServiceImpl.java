package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.domain.CursoMatriculado;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.repository.CursoRepository;
import com.nixvoid.memoamautas.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        return null;
    }

    @Override
    public Curso inscribirCurso(CursoMatriculado cursoMatriculado) {
        return cursoRepository.inscribirCurso(cursoMatriculado);
    }

    @Override
    public Curso obtenerInfo(Curso curso) {
        return cursoRepository.obtenerInfo(curso);
    }

}

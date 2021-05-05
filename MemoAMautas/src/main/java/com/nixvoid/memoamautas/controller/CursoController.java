package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.domain.CursoMatriculado;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/curso", consumes = "application/json;charset=utf-8")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/all")
    public CursoEtiquetado obtenerCursos(@RequestBody Etiqueta etiqueta){
        return cursoService.obtenerCursos(etiqueta);
    }

    @GetMapping("/details")
    public Curso obtenerCursoDetails(@RequestBody Curso curso){
        return cursoService.obtenerCursoDetails(curso);
    }

    @GetMapping("/sesion")
    public Modulo obtenerSesiones(@RequestBody Modulo modulo){
        return cursoService.obtenerSesiones(modulo);
    }

    @GetMapping("/info")
    public Curso obtenerInfo(@RequestBody Curso curso){
        return cursoService.obtenerInfo(curso);
    }

    @PostMapping("/matricula")
    public Curso inscribirCurso(@RequestBody CursoMatriculado cursoMatriculado){
        return cursoService.inscribirCurso(cursoMatriculado);
    }
}

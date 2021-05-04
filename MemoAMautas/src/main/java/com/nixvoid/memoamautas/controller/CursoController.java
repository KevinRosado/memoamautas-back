package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.domain.CursoEtiquetado;
import com.nixvoid.memoamautas.dto.courses.Etiqueta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;
import com.nixvoid.memoamautas.service.CursoService;

import java.util.List;

@RestController
@RequestMapping(value = "", consumes = "application/json;charset=utf-8")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/cursos")
    public CursoEtiquetado obtenerCursos(@RequestBody Etiqueta etiqueta){
        return cursoService.obtenerCursos(etiqueta);
    }

    @GetMapping("/curso")
    public Curso obtenerCursoDetails(@RequestBody Curso curso){
        return cursoService.obtenerCursoDetails(curso);
    }

    @GetMapping("/sesion")
    public Modulo obtenerSesiones(@RequestBody Modulo modulo){
        return cursoService.obtenerSesiones(modulo);
    }

}

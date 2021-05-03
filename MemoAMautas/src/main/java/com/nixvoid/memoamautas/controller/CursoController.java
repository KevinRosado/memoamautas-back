package com.nixvoid.memoamautas.controller;

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
@RequestMapping("/cursos")
public class CursoController {
    @Autowired
    private CursoService cursoService;

    @GetMapping("/curso")
    public List<Curso> obtenerCurso(@RequestBody Curso curso){
        return cursoService.obtenerCurso(curso);
    }

    @GetMapping("/modulo")
    public List<Modulo> obtenerModulo(@RequestBody Curso curso){
        return cursoService.obtenerModulo(curso);
    }

    @GetMapping("/sesion")
    public List<Sesion> obtenerSesion(@RequestBody Curso curso){
        return cursoService.obtenerSesion(curso);
    }

}

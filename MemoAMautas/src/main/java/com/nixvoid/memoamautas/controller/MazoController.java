package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.user.Persona;
import com.nixvoid.memoamautas.service.MazoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(consumes = "application/json;charset=utf-8")
public class MazoController {

    @Autowired
    private MazoService mazoService;

    @GetMapping("/autor")
    public List<Mazo> getByAutor(Persona persona) {
        return mazoService.getByAutor(persona);
    }

    @GetMapping("/mazos")
    public List<Mazo> obtenerMazos(Curso curso) {
        return mazoService.obtenerMazos(curso);
    }
}

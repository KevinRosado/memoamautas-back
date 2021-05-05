package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.courses.Modulo;
import com.nixvoid.memoamautas.dto.courses.Sesion;
import com.nixvoid.memoamautas.dto.user.Persona;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public interface MazoService {
    List<Mazo> getByAutor(Persona persona);
    List<Mazo> obtenerMazos(Curso curso);
    List<Mazo> getByCurso(Curso curso);
    List<Mazo> getBySesion(Sesion sesion);
}
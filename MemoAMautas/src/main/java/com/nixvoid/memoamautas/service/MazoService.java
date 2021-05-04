package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.cards.Mazo;
import com.nixvoid.memoamautas.dto.courses.Curso;
import com.nixvoid.memoamautas.dto.user.Persona;

import java.util.List;

public interface MazoService {
    List<Mazo> getByAutor(Persona persona);
    List<Mazo> obtenerMazos(Curso curso);
}

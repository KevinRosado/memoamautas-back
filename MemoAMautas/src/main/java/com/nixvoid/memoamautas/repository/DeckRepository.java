package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.dto.cards.Deck;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Session;
import com.nixvoid.memoamautas.dto.user.Person;

import java.util.List;

public interface DeckRepository {
    List<Deck> getByAutor(Person person);
    List<Deck> obtenerMazos(Course course);
    List<Deck> getByCurso(Course course);
    List<Deck> getBySesion(Session session);
    void crearMazo(Deck deck);
}

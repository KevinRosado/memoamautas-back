package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.dto.cards.Deck;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Session;
import com.nixvoid.memoamautas.dto.user.Person;

import java.util.List;

public interface DeckService {
    List<Deck> getByAuthor(Person person);
    List<Deck> getAllDecks(Course course);
    List<Deck> getByCourse(Course course);
    List<Deck> getBySession(Session session);
    void createDeck(Deck deck);
}

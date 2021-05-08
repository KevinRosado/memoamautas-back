package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.dto.cards.Deck;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Session;
import com.nixvoid.memoamautas.dto.user.Person;
import com.nixvoid.memoamautas.repository.DeckRepository;
import com.nixvoid.memoamautas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DeckServiceImpl implements DeckService {

    @Autowired
    private DeckRepository deckRepository;

    @Override
    public List<Deck> getByAuthor(Person person) {
        return deckRepository.getByAutor(person);
    }

    @Override
    public List<Deck> getAllDecks(Course course) {
        return deckRepository.obtenerMazos(course);
    }

    @Override
    public List<Deck> getByCourse(Course course) {
        return deckRepository.getByCurso(course);
    }

    @Override
    public List<Deck> getBySession(Session session) {
        return deckRepository.getBySesion(session);
    }

    @Override
    public void createDeck(Deck deck) {
        deckRepository.crearMazo(deck);
    }
}

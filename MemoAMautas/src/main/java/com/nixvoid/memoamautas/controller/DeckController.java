package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.dto.cards.Deck;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Session;
import com.nixvoid.memoamautas.dto.user.Person;
import com.nixvoid.memoamautas.service.DeckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value = "/memo/decks", consumes = "application/json;charset=utf-8")
public class DeckController {

    @Autowired
    private DeckService deckService;

    @GetMapping("/author")
    public List<Deck> getByAuthor(@RequestBody Person person) {
        return deckService.getByAuthor(person);
    }

    @GetMapping("/all")
    public List<Deck> getAllDecks(@RequestBody Course course) {
        return deckService.getAllDecks(course);
    }

    @GetMapping("/course")
    public List<Deck> getByCourse(@RequestBody Course course){
        return deckService.getByCourse(course);
    }

    @GetMapping("/session")
    public List<Deck> getBySession(@RequestBody Session session){
        return deckService.getBySession(session);
    }

    @PostMapping("/new")
    public void createDeck(@RequestBody Deck deck){
        deckService.createDeck(deck);
    }

}


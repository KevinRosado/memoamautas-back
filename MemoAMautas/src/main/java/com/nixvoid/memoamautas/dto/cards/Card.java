package com.nixvoid.memoamautas.dto.cards;

import lombok.Data;

@Data
public class Card {
    private String id;
    private String color;
    private String id_deck;
    private String question;
    private String answer;
    private String question_color;
    private String answer_color;
    private String path_questionimg;
    private String path_answerimg;
}

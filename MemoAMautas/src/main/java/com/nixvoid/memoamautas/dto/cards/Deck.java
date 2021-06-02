package com.nixvoid.memoamautas.dto.cards;

import lombok.Data;

@Data
public class Deck {
    private Integer id;
    private String name;
    private Integer amount_visits;
    private Integer amount_votes;
    private Boolean isdefault;
    private Integer author_code;
    private String author_name;
    private String course_code;
    private String course_name;
    private String session_code;
}

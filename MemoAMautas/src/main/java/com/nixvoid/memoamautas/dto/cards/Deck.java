package com.nixvoid.memoamautas.dto.cards;

import lombok.Data;

@Data
public class Deck {
    private Integer id;
    private String nombre;
    private Integer cant_visitas;
    private Integer cant_votos;
    private Boolean es_default;
    private Integer cod_autor;
    private String nombre_autor;
    private String cod_curso;
    private String nombre_curso;
    private String cod_sesion;
}

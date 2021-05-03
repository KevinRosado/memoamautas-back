package com.nixvoid.memoamautas.dto.cards;

import lombok.Data;

@Data
public class Tarjeta {
    private String id;
    private String color;
    private String id_mazo;
    private String pregunta;
    private String respuesta;
    private String color_pregunta;
    private String color_respuesta;
    private String path_img_pregunta;
    private String path_img_respuesta;
}

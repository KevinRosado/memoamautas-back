package com.nixvoid.memoamautas.domain;

import lombok.Data;

@Data
public class AvanceSesion {
    private String id_avance;
    private String id_persona;
    private String id_sesion;
    private Integer puntuacion;
    private Integer progreso;
}

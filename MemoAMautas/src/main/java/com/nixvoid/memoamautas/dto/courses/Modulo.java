package com.nixvoid.memoamautas.dto.courses;


import lombok.Data;

import java.util.List;

@Data
public class Modulo {
    private String id;
    private String tema;
    private Integer orden;
    private List<Sesion> sesiones;
}

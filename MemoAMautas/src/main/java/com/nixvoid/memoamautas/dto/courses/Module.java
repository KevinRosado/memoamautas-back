package com.nixvoid.memoamautas.dto.courses;

import lombok.Data;

import java.util.List;

@Data
public class Module {
    private String id;
    private String tema;
    private Integer orden;
    private List<Session> sesiones;
}

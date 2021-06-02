package com.nixvoid.memoamautas.dto.courses;

import lombok.Data;

import java.util.List;

@Data
public class Module {
    private String id;
    private String topic;
    private Integer order;
    private List<Session> sessions;
}

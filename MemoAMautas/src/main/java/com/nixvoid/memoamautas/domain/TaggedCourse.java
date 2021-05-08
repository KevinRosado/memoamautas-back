package com.nixvoid.memoamautas.domain;

import com.nixvoid.memoamautas.dto.courses.Course;
import lombok.Data;

import java.util.List;

@Data
public class TaggedCourse {
    private String tipo_etiqueta;
    private String valor_etiqueta;
    private List<Course> courses;
}

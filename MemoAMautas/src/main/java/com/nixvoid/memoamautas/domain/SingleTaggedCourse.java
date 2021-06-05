package com.nixvoid.memoamautas.domain;

import lombok.Data;

@Data
public class SingleTaggedCourse {
    private String tag_type;
    private String tag_name;
    private CourseWithTag course;
}

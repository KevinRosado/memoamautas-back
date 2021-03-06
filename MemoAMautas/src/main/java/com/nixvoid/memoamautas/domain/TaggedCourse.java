package com.nixvoid.memoamautas.domain;

import lombok.Data;

import java.util.List;

@Data
public class TaggedCourse {
    private String tag_type;
    private String tag_name;
    private List<CourseWithTag> courses;
}

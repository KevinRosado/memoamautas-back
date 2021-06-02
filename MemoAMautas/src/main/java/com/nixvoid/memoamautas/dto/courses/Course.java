package com.nixvoid.memoamautas.dto.courses;

import com.nixvoid.memoamautas.dto.user.Person;
import lombok.Data;

import java.util.List;

@Data
public class Course {
    private String id;
    private String name;
    private Integer credits;
    private String description;
    private List<Person> teachers;
    private List<Module> modules;
}

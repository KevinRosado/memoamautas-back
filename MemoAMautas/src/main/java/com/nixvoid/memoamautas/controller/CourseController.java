package com.nixvoid.memoamautas.controller;

import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Module;
import com.nixvoid.memoamautas.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/memo/course", consumes = "application/json;charset=utf-8")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/courseByTag")
    public List<TaggedCourse> getCourses(@RequestParam String tag){
        return courseService.getCourses(tag);
    }

    @GetMapping("/details")
    public Course getCourseDetails(@RequestBody Course course){
        return courseService.getCourseDetails(course);
    }

    @GetMapping("/session")
    public Module getSessions(@RequestBody Module module){
        return courseService.getSessions(module);
    }

    @GetMapping("/info")
    public Course getCourseInfo(@RequestBody Course course){
        return courseService.getCourseInfo(course);
    }

    @PostMapping("/enrollment")
    public Course enrollCourse(@RequestBody EnrolledCourse enrolledCourse){
        return courseService.enrollCourse(enrolledCourse);
    }
}

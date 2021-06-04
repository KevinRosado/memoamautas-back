package com.nixvoid.memoamautas.service.impl;

import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.dto.courses.Module;
import com.nixvoid.memoamautas.dto.courses.Tag;
import com.nixvoid.memoamautas.repository.CourseRepository;
import com.nixvoid.memoamautas.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public TaggedCourse getCourses(String tag) {
        return courseRepository.getCourses(tag);
    }

    @Override
    public Course getCourseDetails(Course course) {
        return courseRepository.getCourseDetails(course);
    }

    @Override
    public Module getSessions(Module module) {
        return null;
    }

    @Override
    public Course enrollCourse(EnrolledCourse enrolledCourse) {
        return courseRepository.enrollCourse(enrolledCourse);
    }

    @Override
    public Course getCourseInfo(Course course) {
        return courseRepository.getCourseInfo(course);
    }

}

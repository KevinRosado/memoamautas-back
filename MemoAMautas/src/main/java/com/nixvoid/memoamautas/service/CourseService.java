package com.nixvoid.memoamautas.service;

import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Module;

import java.util.List;

public interface CourseService {
    List<TaggedCourse> getCourses(String tag);
    Course getCourseDetails(Course course);
    Module getSessions(Module module);
    Course enrollCourse(EnrolledCourse enrolledCourse);
    Course getCourseInfo(Course course);
}

package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.dto.courses.Course;

public interface CourseRepository {
    TaggedCourse getCourses(String tag);
    Course getCourseDetails(Course course);
    Course enrollCourse(EnrolledCourse enrolledCourse);
    Course getCourseInfo(Course course);
}

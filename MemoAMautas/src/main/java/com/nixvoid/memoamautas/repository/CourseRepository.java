package com.nixvoid.memoamautas.repository;

import com.nixvoid.memoamautas.domain.TaggedCourse;
import com.nixvoid.memoamautas.domain.EnrolledCourse;
import com.nixvoid.memoamautas.dto.courses.Course;
import com.nixvoid.memoamautas.dto.courses.Tag;

public interface CourseRepository {
    TaggedCourse getCourses(Tag tag);
    Course getCourseDetails(Course course);
    Course enrollCourse(EnrolledCourse enrolledCourse);
    Course getCourseInfo(Course course);
}

package com.example.spring_demo.course;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Integer> {
     public List<Course> findCoursesByTopicId(int id );
}

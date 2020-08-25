package com.example.spring_demo.course;

import com.example.spring_demo.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;


    @RequestMapping("topics/{topicId}/courses")
    public ArrayList<Course> findAllCourses(@PathVariable int topicId) {
        return courseService.findAllCoursesByTopicId(topicId);
    }

    @RequestMapping("topics/{topicId}/courses/{id}")
    public Course findCourseById(@PathVariable int id) {
        return courseService.findCourseById(id);
    }

    @RequestMapping(value = "topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourses(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, " ", " "));
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.PUT)
    public boolean updateCourse(@RequestBody Course course, @PathVariable int topicId) {
        course.setTopic(new Topic(topicId, " ", " "));
        return courseService.updateCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public boolean deleteTopic(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
}

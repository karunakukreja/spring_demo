package com.example.spring_demo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    public ArrayList<Course> findAllCoursesByTopicId(int topicId) {
        ArrayList<Course> courses = new ArrayList<>() ; // Doesn't update if initialised
        courseRepository.findCoursesByTopicId(topicId).forEach(courses::add);
        return courses;
        // return courses;
    }

    public Course findCourseById(int id){
        return courseRepository.findById(id).get();
        // return topics.stream().filter(t-> t.getId() == id).findFirst().get();

    }

    public void addCourse (Course course) {
        // topics.add(topic);
       courseRepository.save(course);
    }

    public boolean updateCourse (Course course) { // update adds another instance, doesn't update
//        for(int i = 0; i< topics.size(); i++){
//            if(topics.get(i).getId() == topic.getId()) {
//                topics.set(i, topic);
//                return true;
//            }
//        }
//        return false;
         courseRepository.save(course);
         return true;

    }

    public boolean deleteCourse (int id) {
//        for(Topic topic : topics ){
//            if(topic.getId() == id) {
//                topics.remove(topic);
//                return true;
//            }
//        }
//        return false;
         courseRepository.deleteById(id); // How to say if the topic wasn't deleted
        return true;

    }
}

package com.example.spring_demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping("/topics")
    public ArrayList<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @RequestMapping("/topics/{id}")
    public Topic findTopicById(@PathVariable int id) {
        return topicService.findTopicById(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic ) {
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.PUT)
    public boolean updateTopic(@RequestBody Topic topic) {
        return topicService.updateTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public boolean deleteTopic(@PathVariable int id) {
        return topicService.deleteTopic(id);
    }
}

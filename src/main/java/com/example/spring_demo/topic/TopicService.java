package com.example.spring_demo.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


import static com.example.spring_demo.SpringDemoApplication.getEntityManager;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public ArrayList<Topic> findAllTopics() {
//        ArrayList<Topic> topics = new ArrayList<>() ; // Doesm't update if initialised
//        topicRepository.findAll().forEach(topics::add);
//        return topics;
        // return topics;

        // Query:
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Query query =  em.createQuery("from Topic");
        ArrayList<Topic> allTopics = (ArrayList<Topic>) query.getResultList();
        em.getTransaction().commit();
        em.close();
        return allTopics;
    }

    public Topic findTopicById(int id){
//        return topicRepository.findById(id).get();
        // return topics.stream().filter(t-> t.getId() == id).findFirst().get();

        //Query
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("from Topic where topicId = id");
        Topic topic = (Topic) query.getSingleResult();
        em.getTransaction().commit();
        em.close();
        return topic;
    }

    public void addTopic (Topic topic ) {
        // topics.add(topic);
       topicRepository.save(topic);
    }

    public boolean updateTopic (Topic topic ) { // update adds another instance, doesn't update
//        for(int i = 0; i< topics.size(); i++){
//            if(topics.get(i).getId() == topic.getId()) {
//                topics.set(i, topic);
//                return true;
//            }
//        }
//        return false;
         topicRepository.save(topic);
         return true;

    }

    public boolean deleteTopic (int id) {
//        for(Topic topic : topics ){
//            if(topic.getId() == id) {
//                topics.remove(topic);
//                return true;
//            }
//        }
//        return false;
         topicRepository.deleteById(id); // How to say if the topic wasn't deleted
        return true;

    }
}

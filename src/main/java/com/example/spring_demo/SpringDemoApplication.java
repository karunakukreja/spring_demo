package com.example.spring_demo;

import com.example.spring_demo.course.Course;
import com.example.spring_demo.topic.Topic;
import org.hibernate.Criteria;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.transaction.Transactional;
import java.sql.Time;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SpringDemoApplication {
    private static  EntityManagerFactory emf ;

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
        emf = StaticContextAccessor.getBean(EntityManagerFactory.class);
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
//        for(int i =0; i< 10; i++ ){
//            Topic topic = new Topic ("Topic" + i, "Description "+ i);
//            Course course = new Course( "Course "+i, "Description "+ i, topic, i*100);
//            em.persist(course);
//        }


//        int result =(Integer) em.createQuery("Select max(price) from Course").getSingleResult();
//        System.out.println(result);


        //TODO : Check usage
//        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
//        criteriaBuilder.greaterThanOrEqualTo(, 50);
//        CriteriaQuery<Topic> criteriaQuery = criteriaBuilder.createQuery(Topic.class);
//    criteriaQuery.where();

        // Select * from Course where topic_id in [1,2,3];
        // Select id from Topic;
        //  Select Topic_name from Topic INNER JOIN (Select Course.id from Course where price>200) AS "XYZ" ON



        // select * from topics inner join (select topic_id from courses where courses.price > 2000 )
        // tp on topics.id = tp.topic_id;

//        List result = em.createQuery("Select topic.name from Topic topic where topic.id in (Select course.topic.id from Course course where course.price >200 ) ").getResultList();
//        for(int i =0; i< result.size(); i++){
//            System.out.println(result.get(i));
//
//        }

//        List result = em.createQuery("Select topic.name from Topic topic, (Select course.topic.id as topic_id from Course course where course.price >200 ) ABC inner join on topic.id = ABC.topic_id").getResultList();
//        System.out.println(result.get(0));


        class Timepass {
            int number;
            Course course;
            Timepass(){}

            public Timepass(int number, Course course) {
                this.number = number;
                this.course = course;
            }

            @Override
            public String toString() {
                return "Timepass{" +
                        "number=" + number +
                        ", course=" + course +
                        '}';
            }
        }

        List<Map<String, Course>> result = em.createQuery("select new map( max(course.price), course) from Course course group by course.id having course.price> 200").getResultList();
        result.forEach(item -> System.out.println(item));


        em.getTransaction().commit();
        em.close();

    }

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


}

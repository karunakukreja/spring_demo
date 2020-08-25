package com.example.spring_demo.Movie;

import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;
import static com.example.spring_demo.SpringDemoApplication.getEntityManager;

@Service
public class MovieService {

    public Movie getAllMovies() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        //ArrayList<Topic> movies = new ArrayList<>() ;
        return em.find(Movie.class , 1);
    }

    public void addMovie(Movie movie) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        System.out.println(movie);
        em.persist(movie);

        em.getTransaction().commit();
    }
}

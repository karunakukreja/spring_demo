package com.example.spring_demo.Movie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MOVIE")
public class Movie {

    @Id
    private int id;

    private String movieName;

    public Movie() {
    }

    public Movie(int id, String movieName) {
        this.id = id;
        this.movieName = movieName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieName='" + movieName + '\'' +
                '}';
    }
}
package com.example.spring_demo.Movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping (value = "/movies")
    public Movie getAllMovies () {
        return movieService.getAllMovies();
    }

    @RequestMapping (value = "/movies", method = RequestMethod.POST)
    public void addMovie (@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
}

/** AGGREGATE, WHERE IN */
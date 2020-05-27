package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    ActorRepository actorRepository;

    @Autowired
    MovieRepository movieRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Set<Movie> movies = new HashSet<Movie>();
        Set<Actor> actors = new HashSet<Actor>();

        Actor actor = new Actor();
        actor.setStageName("Big Bird");
        actor.setRealName("Big Birdie");

        Movie movie = new Movie();
        movie.setTitle("Sesame Street 1");
        movie.setDescription("Bob builds things");
        movie.setYear(2009);
        movie.setCast(actors);


        Movie movie2 = new Movie();
        movie2.setTitle("Sesame Street 2");
        movie2.setDescription("A bird teaches children again");
        movie2.setYear(1980);
        movie2.setCast(actors);

        actors.add(actor);
        movies.add(movie);
        movies.add(movie2);

        actor.setMovies(movies);
        actorRepository.save(actor);
        movieRepository.save(movie);
        movieRepository.save(movie2);

        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }
}

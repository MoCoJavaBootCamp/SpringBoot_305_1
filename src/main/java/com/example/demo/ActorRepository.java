package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface ActorRepository extends CrudRepository<Movie,Long> {
    Iterator findByAllByYear(Long year);
    Iterator findByAllYearOrderByMovies(Long year);
}

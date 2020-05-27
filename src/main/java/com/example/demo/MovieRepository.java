package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

public interface MovieRepository extends CrudRepository<Movie,Long> {
    Iterator findAllByYear(Long year);
    Iterator findAllByYearOrderByTitle(Long year);
    Iterator findAllByYearOrderByCast(Long year);
}

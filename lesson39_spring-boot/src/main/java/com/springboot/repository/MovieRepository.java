package com.springboot.repository;

import com.springboot.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    /*List<MovieEntity> findByName(String name);*/
}

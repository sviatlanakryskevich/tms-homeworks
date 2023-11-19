package com.springboot.repository;

import com.springboot.domain.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    /*List<MovieEntity> findByName(String name);*/


    @Modifying
    @Query(value = "update MovieEntity set rating = :rating where id = :id")
    void updateRating(Integer id, Double rating);


}

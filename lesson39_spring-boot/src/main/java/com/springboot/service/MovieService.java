package com.springboot.service;

import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieDto> findAll();
    void save(MovieDto request);
    void updateRating(Integer id, Double rating);

    /*List<MovieEntity> findByName(String name);*/

}

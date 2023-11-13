package com.springboot.service;

import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieEntity> findAll();
    void save(MovieDto request);

    /*List<MovieEntity> findByName(String name);*/

}

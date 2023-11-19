package com.springboot.service.impl;

import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;
import com.springboot.mapper.MovieMapper;
import com.springboot.repository.MovieRepository;
import com.springboot.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@RequiredArgsConstructor
@Service
public class MovieServiceImpl implements MovieService {
    private final MovieMapper mapper;
    private final MovieRepository repository;
    @Override
    public List<MovieDto> findAll() {
        List<MovieEntity> all = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        List<MovieDto> dtos = mapper.toDtos(all);
        return dtos;
    }

    @Override
    @Transactional
    public void save(MovieDto request) {
        MovieEntity movie = mapper.toEntity(request);
        repository.save(movie);
    }

    @Override
    @Transactional
    public void updateRating(Integer id, Double rating) {
        repository.updateRating(id, rating);
    }

    /*@Override
    public List<MovieEntity> findByName(String name) {
        return repository.findByName(name);
    }*/
}

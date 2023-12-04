package com.springboot.service.impl;

import com.springboot.domain.Genre;
import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;
import com.springboot.dto.MovieSearchDto;
import com.springboot.mapper.MovieMapper;
import com.springboot.repository.MovieRepository;
import com.springboot.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import javax.transaction.Transactional;
import java.util.ArrayList;
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

    @Override
    public List<MovieEntity> findBySpecification(MovieSearchDto movieSearchDto) {
        Specification<MovieEntity> specification = createSpecification(movieSearchDto);

        List<MovieEntity> all = repository.findAll(specification);
        return all;
    }

    private Specification<MovieEntity> createSpecification(MovieSearchDto dto){
        return (root, query, criteriaBuilder) -> {
            String name = dto.getName();
            Genre genre = dto.getGenre();
            Double ratingFrom = dto.getRatingFrom();
            Double ratingTo = dto.getRatingTo();

            ArrayList<Predicate> predicates = new ArrayList<>();

            if(name != null && !name.isBlank()){
                Predicate nameLike = criteriaBuilder.like(root.get("name"), "%" + name + "%");
                predicates.add(nameLike);
            }
            if(genre !=null){
                Predicate genreEq = criteriaBuilder.equal(root.get("genre"), genre);
                predicates.add(genreEq);
            }
            if(ratingFrom != null){
                Predicate ratingGe = criteriaBuilder.ge(root.get("rating"), ratingFrom);
                predicates.add(ratingGe);
            }
            if(ratingTo != null){
                Predicate ratingLe = criteriaBuilder.le(root.get("rating"), ratingTo);
                predicates.add(ratingLe);
            }
            Predicate[] array = predicates.toArray(Predicate[]::new);
            return criteriaBuilder.and(array);
        };
    }
}

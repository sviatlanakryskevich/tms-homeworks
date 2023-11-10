package com.springboot.mapper;

import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MovieMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "yearRelease", source = "yearRelease")
    @Mapping(target = "rating", source = "rating")
    @Mapping(target = "genre", source = "genre")
    MovieEntity toEntity(MovieDto dto);
}

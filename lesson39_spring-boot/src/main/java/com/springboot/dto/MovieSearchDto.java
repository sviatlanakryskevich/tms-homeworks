package com.springboot.dto;

import com.springboot.domain.Genre;
import lombok.Data;

@Data
public class MovieSearchDto {
    private String name;
    private Genre genre;
    private Double ratingFrom;
    private Double ratingTo;
}

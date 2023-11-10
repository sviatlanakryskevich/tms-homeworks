package com.springboot.dto;

import com.springboot.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private String name;
    private Genre genre;
    private Integer yearRelease;
    private Double rating;
}

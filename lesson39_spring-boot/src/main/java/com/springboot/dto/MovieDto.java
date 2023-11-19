package com.springboot.dto;

import com.springboot.domain.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;
    private String name;
    private Genre genre;
    private Integer yearRelease;
    private Double rating;
}

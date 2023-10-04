package com.tms.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Horse {
    private String name;

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }
}

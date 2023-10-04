package com.tms.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pair {
    private Horse horse;
    private Rider rider;
    private Double speed;
    private int number;

    public Double changeSpeed() {
        speed = (Math.random() * (3.0 - 0.1) + 0.1);
        return speed;
    }

    @Override
    public String toString() {
        return "{" +
                "horse=" + horse +
                ", rider=" + rider +
                '}';
    }
}

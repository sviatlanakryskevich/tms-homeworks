package com.tms.spring.service;

import com.tms.spring.domain.Pair;

import java.util.List;

public interface HorseRacingService {
    void startRace(List<Pair> pairs) throws InterruptedException;
}

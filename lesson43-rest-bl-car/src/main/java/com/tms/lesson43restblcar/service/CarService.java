package com.tms.lesson43restblcar.service;

import com.tms.lesson43restblcar.dto.CarDto;

import java.util.List;

public interface CarService {
    CarDto save(CarDto dto);
    List<CarDto> getAll();
}

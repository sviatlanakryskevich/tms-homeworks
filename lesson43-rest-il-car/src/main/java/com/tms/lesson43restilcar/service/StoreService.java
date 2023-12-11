package com.tms.lesson43restilcar.service;
import com.tms.lesson43restilcar.dto.CarDto;
import java.util.List;

public interface StoreService {
    CarDto register(CarDto dto);
    List<CarDto> getAll();
    CarDto getById(Integer id);
}

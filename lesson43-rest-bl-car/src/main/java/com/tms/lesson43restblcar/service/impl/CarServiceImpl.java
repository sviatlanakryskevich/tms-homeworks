package com.tms.lesson43restblcar.service.impl;

import com.tms.lesson43restblcar.dto.CarDto;
import com.tms.lesson43restblcar.entity.CarEntity;
import com.tms.lesson43restblcar.mapper.CarMapper;
import com.tms.lesson43restblcar.repository.CarRepository;
import com.tms.lesson43restblcar.service.CarService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
public class CarServiceImpl implements CarService {
    private final CarMapper mapper;
    private final CarRepository repository;

    @Override
    public CarDto save(CarDto dto) {
        CarEntity entity = mapper.toEntity(dto);
        CarEntity saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public List<CarDto> getAll() {
        List<CarEntity> all = repository.findAll();
        return mapper.toDtos(all);
    }
}

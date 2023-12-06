package com.tms.lesson43restilcar.service.impl;

import com.tms.lesson43restilcar.dto.CarDto;
import com.tms.lesson43restilcar.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final RestTemplate template;
    @Override
    public CarDto register(CarDto dto) {
        ResponseEntity<CarDto> carDtoResponseEntity = template.postForEntity("http://127.0.0.1:8081/cars", dto, CarDto.class);
        return carDtoResponseEntity.getBody();
    }
}

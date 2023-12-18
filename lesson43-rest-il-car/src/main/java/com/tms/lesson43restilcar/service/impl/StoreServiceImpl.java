package com.tms.lesson43restilcar.service.impl;
import com.tms.lesson43restilcar.client.CarClient;
import com.tms.lesson43restilcar.dto.CarDto;
import com.tms.lesson43restilcar.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService {
    private final CarClient client;
    @Override
    public CarDto register(CarDto dto) {
        return client.save(dto);
    }

    @Override
    public List<CarDto> getAll() {
        return client.findAll();
    }

    @Override
    public CarDto getById(Integer id) {
        return client.findById(id);
    }
}

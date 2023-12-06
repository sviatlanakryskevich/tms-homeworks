package com.tms.lesson43restblcar.web;

import com.tms.lesson43restblcar.dto.CarDto;
import com.tms.lesson43restblcar.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cars")
public class CarController {
    private final CarService service;

    @PostMapping
    public CarDto save(@RequestBody CarDto request){
       return service.save(request);
    }

    @GetMapping
    public List<CarDto> findAll(){
        return service.getAll();
    }
}

package com.tms.lesson43restilcar.web;
import com.tms.lesson43restilcar.dto.CarDto;
import com.tms.lesson43restilcar.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")
public class CarController {
    private final StoreService service;
    @PostMapping
    public ResponseEntity<CarDto> save(@RequestBody CarDto dto){

        CarDto car = service.register(dto);
        return ResponseEntity.status(201).body(car);
    }

    @GetMapping
    public List<CarDto> getAll(){
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CarDto getById(@PathVariable(name = "id") Integer id){
        return service.getById(id);
    }
}

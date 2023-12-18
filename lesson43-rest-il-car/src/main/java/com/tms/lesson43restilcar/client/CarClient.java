package com.tms.lesson43restilcar.client;
import com.tms.lesson43restilcar.config.FeignConfig;
import com.tms.lesson43restilcar.dto.CarDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
@FeignClient(name = "car-client", url = "http://127.0.0.1:8081", path = "/cars", configuration = FeignConfig.class)
public interface CarClient {
    @PostMapping
    CarDto save(@RequestBody CarDto request);

    @GetMapping
    List<CarDto> findAll();

    @GetMapping("/{id}")
    CarDto findById(@PathVariable(name = "id") Integer id);

}

package com.tms.lesson43restilcar.web;
import com.tms.lesson43restilcar.dto.CarDto;
import com.tms.lesson43restilcar.dto.exc.IlErrorMessage;
import com.tms.lesson43restilcar.service.StoreService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/store/cars")
@OpenAPIDefinition(info = @Info(
        title = "This is controller for work with cars",
        description = "There are contained CRUD operations with cars",
        version = "0.0.1"
))
public class CarController {
    private final StoreService service;
    @PostMapping
    @Operation(
            tags = "CRUD",
            description = "Method to create car",
            summary = "Just create car",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car is created successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = CarDto.class)
                            )

                    )
            }
    )
    public ResponseEntity<CarDto> save(@RequestBody CarDto dto){

        CarDto car = service.register(dto);
        return ResponseEntity.status(201).body(car);
    }


    @GetMapping
    @Operation(
            tags = "CRUD",
            description = "Method to get all cars",
            summary = "Just get all cars",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car is gotten successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(implementation = CarDto.class)
                                    )
                            )

                    )
            }
    )
    public List<CarDto> getAll(){
        return service.getAll();
    }


    @GetMapping("/{id}")
    @Operation(
            tags = "CRUD",
            description = "Method to find car by id",
            summary = "Just find car by id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "car is found successfully",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                    implementation = CarDto.class
                            ))

                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "car with this id doesn't exist",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = IlErrorMessage.class)
                            )

                    )
            }
    )
    public CarDto getById(@PathVariable(name = "id") Integer id){
        return service.getById(id);
    }
}

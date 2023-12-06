package com.tms.lesson43restblcar.mapper;

import com.tms.lesson43restblcar.dto.CarDto;
import com.tms.lesson43restblcar.entity.CarEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CarMapper {
    CarEntity toEntity(CarDto dto);

    CarDto toDto(CarEntity entity);

    List<CarDto> toDtos(List<CarEntity> all);
}

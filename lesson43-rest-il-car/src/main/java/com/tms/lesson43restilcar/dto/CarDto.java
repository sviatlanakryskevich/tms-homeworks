package com.tms.lesson43restilcar.dto;
import com.tms.lesson43restilcar.domain.Model;
import com.tms.lesson43restilcar.validation.CheckCarNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Integer id;
    private Model model;
    @CheckCarNumber
    private String number;
}

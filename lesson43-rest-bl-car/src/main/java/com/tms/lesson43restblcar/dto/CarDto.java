package com.tms.lesson43restblcar.dto;
import com.tms.lesson43restblcar.domain.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {
    private Integer id;
    private Model model;
    private String number;

}

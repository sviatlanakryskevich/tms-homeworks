package com.tms.lesson43restilcar.dto.exc;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IlErrorMessage {
    private String errorDetails;
    private String serviceName;
    private String action;

}

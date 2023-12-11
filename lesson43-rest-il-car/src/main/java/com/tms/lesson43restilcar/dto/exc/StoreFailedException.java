package com.tms.lesson43restilcar.dto.exc;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StoreFailedException extends RuntimeException{
    @JsonProperty("message")
    private final String errorMessage;
    private final String serviceName;
    private final Integer code;
}

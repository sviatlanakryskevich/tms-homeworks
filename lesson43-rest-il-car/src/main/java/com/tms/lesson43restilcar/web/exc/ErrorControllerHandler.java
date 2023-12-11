package com.tms.lesson43restilcar.web.exc;
import com.tms.lesson43restilcar.dto.exc.IlErrorMessage;
import com.tms.lesson43restilcar.dto.exc.StoreFailedException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerHandler {
    @ExceptionHandler(StoreFailedException.class)
    public ResponseEntity<IlErrorMessage> handle(StoreFailedException e){
        Integer code = e.getCode();
        String serviceName = e.getServiceName();
        String errorMessage = e.getErrorMessage();

        IlErrorMessage ilErrorMessage = new IlErrorMessage();
        ilErrorMessage.setServiceName(serviceName);
        ilErrorMessage.setErrorDetails(errorMessage);
        ilErrorMessage.setAction("get car by id");

        return ResponseEntity.status(code).body(ilErrorMessage);

    }
}

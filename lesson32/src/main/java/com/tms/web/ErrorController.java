package com.tms.web;

import com.tms.exception.UserNoAccessRoleException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(UserNoAccessRoleException.class)
    public String getError(UserNoAccessRoleException exc){
        System.out.println("Error: user has role without access" + exc.getUser());
        return "roleError";
    }
}

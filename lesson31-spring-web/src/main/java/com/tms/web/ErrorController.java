package com.tms.web;

import com.tms.exception.UserNameEmptyException;
import com.tms.exception.UserNoAccessRoleException;
import com.tms.exception.UserRoleEmptyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(UserNameEmptyException.class)
    public String getError(UserNameEmptyException exc){
        System.out.println("Empty user's name" + exc.getUser());
        return "error";
    }
    @ExceptionHandler(UserRoleEmptyException.class)
    public String getError(UserRoleEmptyException exc){
        System.out.println("Empty user's role" + exc.getUser());
        return "error";
    }
    @ExceptionHandler(UserNoAccessRoleException.class)
    public String getError(UserNoAccessRoleException exc){
        System.out.println("Error: user has role without access" + exc.getUser());
        return "roleError";
    }
}

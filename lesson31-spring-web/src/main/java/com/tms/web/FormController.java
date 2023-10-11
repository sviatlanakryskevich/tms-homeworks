package com.tms.web;

import com.tms.domain.User;
import com.tms.exception.UserNameEmptyException;
import com.tms.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/form")
public class FormController {

    private final UserService userService;

    @GetMapping
    public String formPage(){

        return "form";
    }

    @PostMapping
    public String addUser(User user){
        userService.saveUser(user);
        return "form";
    }


}

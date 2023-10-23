package com.tms.web;

import com.tms.domain.User;
import com.tms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
@RequestMapping("/form")
public class FormController {

    private final UserService userService;

    @GetMapping
    public ModelAndView formPage(){
        ModelAndView modelAndView = new ModelAndView("form");
      /*  modelAndView.addObject("users", userService.getUsers());*/
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@Valid User user, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("form");
        if(result.hasFieldErrors()){
            result.getFieldErrors()
                    .forEach(fieldError -> {
                        String field = fieldError.getField();
                        String defaultMessage = fieldError.getDefaultMessage();
                        modelAndView.addObject(field + "Error", defaultMessage);
                    });
        }
        if(!result.hasFieldErrors()){
            userService.saveUser(user);
        }

        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }


}

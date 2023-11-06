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
    public ModelAndView formPage(@ModelAttribute(name = "user") User user){
        ModelAndView modelAndView = new ModelAndView("form");
        return modelAndView;
    }

    @PostMapping
    public ModelAndView addUser(@ModelAttribute(name = "user")@Valid User user, BindingResult result){
        ModelAndView modelAndView = new ModelAndView("form");

        if(!result.hasFieldErrors()){
            userService.saveUser(user);
            modelAndView.addObject("user", new User());
        }

        modelAndView.addObject("users", userService.getUsers());
        return modelAndView;
    }


}

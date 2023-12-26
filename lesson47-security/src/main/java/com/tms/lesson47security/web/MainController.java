package com.tms.lesson47security.web;

import com.tms.lesson47security.model.UserDto;
import com.tms.lesson47security.service.DBUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class MainController {
    private final DBUserDetailsService service;
    @GetMapping("/public")
    public String publicPage(){
        return "public";
    }

    @GetMapping("/private")
    public String privatePage(){
        return "private";
    }

    @GetMapping("/access")
    public String accessPage(){
        return "access";
    }
    @GetMapping("/welcome")
    public String logout(){
        return "welcome";
    }

    @PostMapping("/register")
    public String save(UserDto user){
        service.save(user);
        return "public";
    }

}

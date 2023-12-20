package com.tms.lesson47security.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MainController {
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

}

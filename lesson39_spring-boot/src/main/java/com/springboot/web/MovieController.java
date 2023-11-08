package com.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class MovieController {
    @GetMapping("/movie")
    public String moviePage(){
        return "movie";
    }
}

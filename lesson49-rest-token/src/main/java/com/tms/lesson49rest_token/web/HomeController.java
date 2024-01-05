package com.tms.lesson49rest_token.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HomeController {
    @GetMapping("/auth")
    public void auth(){

    }

    @GetMapping("/private")
    public String priv(){
        return "private";
    }

    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
}

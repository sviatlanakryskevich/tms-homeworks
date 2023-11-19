package com.springboot.web;

import com.springboot.domain.Genre;
import com.springboot.domain.MovieEntity;
import com.springboot.dto.MovieDto;
import com.springboot.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping
public class MovieController {
    private final MovieService service;
    private final String MAIN_PAGE = "main";
    @GetMapping("/")
    public ModelAndView moviePage(){
        ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
        modelAndView.addObject("movies", service.findAll());
        modelAndView.addObject("genres", Genre.values());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(MovieDto request){
        service.save(request);
        return  "redirect:/";
    }

    @PostMapping("/update/{id}")
    public ModelAndView update(@PathVariable(name = "id") Integer id,
                         @RequestParam(name = "rating") Double rating){
        ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
        service.updateRating(id, rating);
        modelAndView.addObject("movies", service.findAll());
        modelAndView.addObject("genres", Genre.values());
        return  modelAndView;
    }

    /*@GetMapping("/get")
    public ModelAndView getByName(@RequestParam(name = "name") String name){
        ModelAndView modelAndView = new ModelAndView(MAIN_PAGE);
        List<MovieEntity> byName = service.findByName(name);
        modelAndView.addObject("movies", service.findAll());

        modelAndView.addObject("genres", Genre.values());
        modelAndView.addObject("movies", byName);
        return modelAndView;
    }*/
}

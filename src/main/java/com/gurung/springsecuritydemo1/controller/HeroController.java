package com.gurung.springsecuritydemo1.controller;

import com.gurung.springsecuritydemo1.entity.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello(){
        return "hello!!";
    }

    @PostMapping("/save-hero")
    @ResponseStatus(HttpStatus.CREATED)
    public Hero saveHero(@RequestBody Hero hero){
        return hero;
    }


}

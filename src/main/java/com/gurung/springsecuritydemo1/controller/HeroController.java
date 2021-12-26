package com.gurung.springsecuritydemo1.controller;

import com.gurung.springsecuritydemo1.entity.Hero;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hero")
@RequiredArgsConstructor
public class HeroController {

    @GetMapping("/get-hero")
    @ResponseStatus(HttpStatus.OK)
    public Hero getHero() {
        Hero hero100 = Hero.builder().id(100).name("name100").build();
        return hero100;
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "hello!!";
    }

    @PostMapping("/save-hero")
    @ResponseStatus(HttpStatus.CREATED)
    public Hero saveHero(@RequestBody Hero hero) {
        return hero;
    }

    @GetMapping("/get-hero-by-id/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Hero getHeroById(@PathVariable("id") int id) {
        Hero hero = Hero.builder()
                .id(id)
                .name("name" + id)
                .build();
        return hero;
    }

    @DeleteMapping("/delete-hero-by-id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteHeroById(@PathVariable("id") int id) {
        System.out.println("delete REST is called with id: " + id);
    }
}

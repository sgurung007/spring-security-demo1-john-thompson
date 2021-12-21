package com.gurung.springsecuritydemo1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/get-hello")
    @ResponseStatus(HttpStatus.OK)
    public String getHello(){
        return "hello";
    }

    @GetMapping("/get-hello-message/{message}")
    @ResponseStatus(HttpStatus.OK)
    public String getHellowithMessage(@PathVariable String message){
        return "hello "+message+"!!";
    }
}

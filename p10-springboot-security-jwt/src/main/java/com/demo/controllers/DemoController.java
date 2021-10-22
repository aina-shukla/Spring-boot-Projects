package com.demo.controllers;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    
    // localhost:8080/greet
    @GetMapping("/greet")
    public String greet(){
        return "Welcome user";
    }

    // localhost:8080/today
    @GetMapping("/today")
    public LocalDateTime today(){
        return LocalDateTime.now();
    }

}
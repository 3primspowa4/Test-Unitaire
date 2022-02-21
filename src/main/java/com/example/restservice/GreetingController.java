package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;
@RestController
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting() {
        return "Hello Test4";
    }

}
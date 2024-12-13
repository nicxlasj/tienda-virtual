package com.nico.tienda_virtual.web.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class HelloWorldController {
    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/hola")
    public String greet() {
        return "Hello world!";
    }
}

package com.example.unit_converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/length")
    public String getLength() {
        return "length.html";
    }

    @GetMapping("/weight")
    public String getWeight() {
        return "weight.html";
    }

    @GetMapping("/temp")
    public String getTemp() {
        return "temp.html";
    }

    @PostMapping("/length")
    public String postLength() {
        return "length.html";
    }

    @PostMapping("/weight")
    public String postWeight() {
        return "weight.html";
    }

    @PostMapping("/temp")
    public String postTemp() {
        return "temp.html";
    }

}

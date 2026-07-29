package com.example.unit_converter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/length")
    public String getLength(Model model) {
        model.addAttribute("converterDisplay", "block");
        model.addAttribute("answerDisplay", "none");
        return "length";
    }

    @GetMapping("/weight")
    public String getWeight() {
        return "weight";
    }

    @GetMapping("/temp")
    public String getTemp() {
        return "temp";
    }

    @PostMapping("/length")
    public String postLength(Model model) {
        model.addAttribute("converterDisplay", "none");
        model.addAttribute("answerDisplay", "block");
        return "length";
    }

    @PostMapping("/weight")
    public String postWeight() {
        return "weight";
    }

    @PostMapping("/temp")
    public String postTemp() {
        return "temp";
    }

}

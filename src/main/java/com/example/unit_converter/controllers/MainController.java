package com.example.unit_converter.controllers;

import com.example.unit_converter.services.ConverterService;
import com.example.unit_converter.services.GeneralHelperService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {


    @GetMapping("/length")
    public String getLength(Model model) {
        viewSetter(model, false);
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
    public String postLength(@RequestParam double value,
                             @RequestParam String convertFrom,
                             @RequestParam String convertTo,
                             Model model, @Qualifier("length")ConverterService converterService) {

        if (inputValidator(convertTo, convertFrom)) {
            return "redirect:/length";
        }
        viewSetter(model, true);
        valueProcessor(convertTo, convertFrom, value, converterService);

        return "/length";
    }

    @PostMapping("/weight")
    public String postWeight() {
        return "weight";
    }

    @PostMapping("/temp")
    public String postTemp() {
        return "temp";
    }

    static double valueProcessor(String convertTo, String convertFrom,
                                 double value, ConverterService converterService) {
        double baseUnit = converterService.convertToBaseUnit(convertFrom, value);
        double finalAnswer = converterService.convertFromBaseUnit(convertTo, baseUnit);

        finalAnswer = (int)(10000*finalAnswer) / 10000.0;

        return finalAnswer;
    }

    static boolean inputValidator(String convertTo, String convertFrom) {
        return !GeneralHelperService.inputValidator(convertTo)
                && !GeneralHelperService.inputValidator(convertFrom);
    }

    static void viewSetter(Model model, boolean updatingToAnswer) {
        if (updatingToAnswer) {
            model.addAttribute("converterDisplay", "none");
            model.addAttribute("answerDisplay", "block");
        } else {
            model.addAttribute("converterDisplay", "block");
            model.addAttribute("answerDisplay", "none");
        }

    }

}

package com.example.unit_converter.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class GeneralHelperService {
    static String[] validWords = {"millimeter", "centimeter", "kilometer", "inch",
            "foot", "yard", "mile", "milligram", "gram",
            "kilogram", "ounce", "pound", "celsius", "farenheit",
            "kelvin"};
    boolean inputChecker(String input) {
        boolean isValid = false;
        for(String validWord : validWords) {
            if(input.toLowerCase().equals(validWord)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }

    public double valueProcessor(String convertTo, String convertFrom,
                                 double value, ConverterService converterService) {
        double baseUnit = converterService.convertToBaseUnit(convertFrom, value);
        double finalAnswer = converterService.convertFromBaseUnit(convertTo, baseUnit);
        return (int)(10000*finalAnswer) / 10000.0;
    }

    // it's weird but returning true for this method means the input isn't valid
    public boolean inputValidator(String convertTo, String convertFrom) {
        return !this.inputChecker(convertTo)
                && !this.inputChecker(convertFrom);
    }

    public void viewSetter(Model model, boolean updatingToAnswer) {
        if (updatingToAnswer) {
            model.addAttribute("converterDisplay", "none");
            model.addAttribute("answerDisplay", "block");
        } else {
            model.addAttribute("converterDisplay", "block");
            model.addAttribute("answerDisplay", "none");
        }

    }

    public void answerSetter(Model model, double value, double finalAnswer, String convertTo, String convertFrom) {
        model.addAttribute("originalValue", value);
        model.addAttribute("finalAnswer", finalAnswer);
        model.addAttribute("unitConvertTo", convertTo);
        model.addAttribute("unitConvertFrom", convertFrom);
    }
}

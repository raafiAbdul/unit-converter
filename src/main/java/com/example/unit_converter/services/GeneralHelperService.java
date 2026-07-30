package com.example.unit_converter.services;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

@Service
public class GeneralHelperService {
    private final String[][] validWords = {{"millimeter", "mm"}, {"centimeter", "cm"}, {"kilometer", "km"},
            {"inch", "in"}, {"foot", "ft"}, {"yard", "yd"}, {"mile", "mi"}, {"milligram", "mg"}, {"gram", "g"},
            {"kilogram", "kg"}, {"ounce", "oz"}, {"pound", "lb"}, {"celsius", "C"}, {"farenheit", "F"},
            {"kelvin", "K"}, {"meter", "m"}};

    private static Map<String, String> unitsMap = new HashMap<>();

    boolean inputChecker(String input) {
        for(int i = 0; i < validWords.length; i++) {
            unitsMap.put(validWords[i][0], validWords[i][1]);
        }
        return unitsMap.containsKey(input);
    }

    public double valueProcessor(String convertFrom, String convertTo,
                                 double value, ConverterService converterService) throws Exception {
        double baseUnit = converterService.convertToBaseUnit(convertFrom.toLowerCase(), value);
        double finalAnswer = converterService.convertFromBaseUnit(convertTo.toLowerCase(), baseUnit);
        return Math.round(finalAnswer * 100000.0) / 100000.0;
    }

    public void inputValidator(String convertFrom, String convertTo) throws Exception {
        boolean isValid = this.inputChecker(convertTo)
                && this.inputChecker(convertFrom);
        if(!isValid) {
            throw new Exception();
        }
    }

    public void viewSetter(Model model, boolean updatingToAnswer, boolean enteredInvalidInput) {
        if (updatingToAnswer) {
            model.addAttribute("converterDisplay", "none");
            model.addAttribute("answerDisplay", "block");
        } else {
            model.addAttribute("converterDisplay", "block");
            model.addAttribute("answerDisplay", "none");
        }

        if(enteredInvalidInput) {
            model.addAttribute("message", "Invalid Input");
        } else {
            model.addAttribute("message", "");
        }

    }

    public void answerSetter(Model model, double value, double finalAnswer, String convertTo, String convertFrom) {
        model.addAttribute("originalValue", value);
        model.addAttribute("finalAnswer", finalAnswer);
        model.addAttribute("unitConvertTo", unitsMap.get(convertTo.toLowerCase()));
        model.addAttribute("unitConvertFrom", unitsMap.get(convertFrom.toLowerCase()));
    }

    public double checkIfValidDouble(String value) throws Exception {
        double parsedValue;
        try {
            parsedValue = Double.parseDouble(value);
        } catch (Exception e) {
            throw new Exception();
        }
        return parsedValue;
    }
}

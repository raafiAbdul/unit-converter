package com.example.unit_converter.services;

public class InputValidatorService {
    static String[] validWords = {"millimeter", "centimeter", "kilometer", "inch",
            "foot", "yard", "mile", "milligram", "gram",
            "kilogram", "ounce", "pound", "celsius", "farenheit",
            "kelvin"};
    public static boolean inputValidator(String input) throws Exception {
        boolean isValid = false;
        for(String validWord : validWords) {
            if(input.toLowerCase().equals(validWord)) {
                isValid = true;
                break;
            }
        }
        return isValid;
    }
}

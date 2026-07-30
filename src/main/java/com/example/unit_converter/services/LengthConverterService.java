package com.example.unit_converter.services;

import org.springframework.stereotype.Service;

@Service("length")
public class LengthConverterService implements ConverterService {
    @Override
    public double convertToBaseUnit(String convertFrom, double value) throws Exception {
        switch(convertFrom.toLowerCase()) {
            case "meter" -> { return value; }
            case "millimeter" -> value =  value / 1000.0;
            case "centimeter" -> value =  value / 100.0;
            case "kilometer" ->  value =  value * 1000;
            case "inch" -> value =  value / 39.3701;
            case "foot" -> value =  value / 3.28084;
            case "yard" -> value = value / 1.09361;
            case "mile" -> value =  value * 0.000621371;
            default -> throw new Exception();
        }
        return value;
    }

    @Override
    public double convertFromBaseUnit(String convertTo, double value) throws Exception {
        switch(convertTo.toLowerCase()) {
            case "meter" -> { return value; }
            case "millimeter" -> value =  value * 1000.0;
            case "centimeter" -> value =  value * 100.0;
            case "kilometer" ->  value =  value / 1000.0;
            case "inch" -> value =  value * 39.3701;
            case "foot" -> value =  value * 3.28084;
            case "yard" -> value = value * 1.09361;
            case "mile" -> value =  value / 0.000621371;
            default -> throw new Exception();
        }
        return value;
    }
}

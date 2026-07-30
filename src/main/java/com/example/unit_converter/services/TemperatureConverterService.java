package com.example.unit_converter.services;

import org.springframework.stereotype.Service;

public class TemperatureConverterService implements ConverterService {
    @Override
    public double convertToBaseUnit(String convertFrom, double value) {
        switch(convertFrom) {
            case "celsius" -> {return value;}
            case "farenheit" -> value = (value - 32) * (5/9.0);
            case "kelvin" -> value = value - 273.15;
        }
        return value;
    }

    @Override
    public double convertFromBaseUnit(String convertTo, double value) {
        switch(convertTo) {
            case "celsius" -> {return value;}
            case "farenheit" -> value = (value * (9/5.0)) - 32;
            case "kelvin" -> value = value + 273.15;
        }
        return value;
    }
}
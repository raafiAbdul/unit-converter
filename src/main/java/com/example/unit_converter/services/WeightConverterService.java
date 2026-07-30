package com.example.unit_converter.services;

import org.springframework.stereotype.Service;

@Service("weight")
public class WeightConverterService implements ConverterService{

    @Override
    public double convertToBaseUnit(String convertFrom, double value) {
        switch(convertFrom) {
            case "kilogram" -> {return value;}
            case "milligram" -> value = value * 1e6;
            case "gram" -> value = value * 1e3;
            case "pound" -> value = value / 2.20462;
            case "ounce" -> value = value / 35.274;
        }
        return value;
    }

    @Override
    public double convertFromBaseUnit(String convertTo, double value) {
        switch (convertTo) {
            case "kilogram" -> {return value;}
            case "milligram" -> value = value / 1e6;
            case "gram" -> value = value / 1e3;
            case "pound" -> value = value * 2.20462;
            case "ounce" -> value = value * 35.274;
        }
        return value;
    }
}

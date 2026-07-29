package com.example.unit_converter.services;

public class LengthConverterService implements ConverterService {
    @Override
    public double convertToBaseUnit(String unitToConvertFrom, double value) {
        switch(unitToConvertFrom.toLowerCase()) {
            case "" -> {}
        }
        return 0.92;
    }

    @Override
    public double convertFromBaseUnit(String unitToConvertTo, double value) {

        return 0.02;
    }
}

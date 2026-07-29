package com.example.unit_converter.services;

public interface ConverterService {
    abstract double convertToBaseUnit(String unitToConvertFrom, double value);
    abstract double convertFromBaseUnit(String unitToConvertTo, double value);
}

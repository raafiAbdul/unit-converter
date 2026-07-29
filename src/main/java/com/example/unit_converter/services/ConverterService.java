package com.example.unit_converter.services;

public interface ConverterService {
    abstract double convertToBaseUnit(String convertFrom, double value);
    abstract double convertFromBaseUnit(String convertTo, double value);
}

package com.example.unit_converter.services;

public interface ConverterService {
    abstract double convertToBaseUnit(String convertFrom, double value) throws Exception;
    abstract double convertFromBaseUnit(String convertTo, double value) throws Exception;
}

package com.example.unit_converter.services;

import org.springframework.stereotype.Service;

@Service
public class TemperatureConverterService implements ConverterService{

    @Override
    public double convertToBaseUnit(String convertFrom, double value) {
        switch(convertFrom) {

        }
    }

    @Override
    public double convertFromBaseUnit(String convertTo, double value);
}

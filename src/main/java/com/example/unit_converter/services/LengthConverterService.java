package com.example.unit_converter.services;

import org.springframework.stereotype.Service;

@Service("length")
public class LengthConverterService implements ConverterService {
    @Override
    public double convertToBaseUnit(String convertFrom, double value) {
        switch(convertFrom.toLowerCase()) {
            case "" -> {}
        }
        return 0.92;
    }

    @Override
    public double convertFromBaseUnit(String convertTo, double value) {

        return 0.02;
    }
}

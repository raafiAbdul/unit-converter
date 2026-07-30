package com.example.unit_converter.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralHelperServiceTest {

    private static final GeneralHelperService generalHelperService = new GeneralHelperService();
    private static final ConverterService lengthConverterService = new LengthConverterService();
    // testing inputChecker method
    @Test
    void invalidWordInInputChecker() {
        assertFalse(generalHelperService.inputChecker("bomboclat"));
    }

    @Test
    void validWordInInputChecker() {
        assertTrue(generalHelperService.inputChecker("meter"));
    }

    // testing inputValidator

    @Test
    void testingInputValidator() throws Exception {
        assertThrows(Exception.class, () -> {
            generalHelperService.inputValidator("no", "meter");
        });
    }

    // testing valueProcessor

    @Test
    void inchesToYards() throws Exception {
        double value = (65 / 39.3701) * 1.09361;
        double finalAnswer = Math.round(value * 100000.0) / 100000.0;
        assertEquals(finalAnswer, generalHelperService.valueProcessor("inch",
                "yard", 65, lengthConverterService));
    }

    @Test
    void yardsToKilometers() throws Exception {
        double value = (65 / 1.09361) / 1000.0;
        double finalAnswer = Math.round(value * 100000.0) / 100000.0;
        assertEquals(finalAnswer, generalHelperService.valueProcessor("yard",
                "kilometer", 65, lengthConverterService));
    }

    // test parsing doubles method

    @Test
    void shouldNotBeAbleToParse() {
        assertThrows(Exception.class, ()-> {
            generalHelperService.checkIfValidDouble("hi");
        });
    }

}
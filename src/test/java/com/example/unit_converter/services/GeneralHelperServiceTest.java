package com.example.unit_converter.services;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralHelperServiceTest {
    // testing inputChecker method
    @Test
    void invalidWordInInputChecker() {
        GeneralHelperService generalHelperService = new GeneralHelperService();
        assertFalse(generalHelperService.inputChecker("bomboclat"));
    }

    @Test
    void validWordInInputChecker() {
        GeneralHelperService generalHelperService = new GeneralHelperService();
        assertTrue(generalHelperService.inputChecker("meter"));
    }

    // testing inputValidator

    @Test
    void testingInputValidator() {
        GeneralHelperService generalHelperService = new GeneralHelperService();
        assertTrue(generalHelperService.inputValidator("no", "meter"));
    }
}
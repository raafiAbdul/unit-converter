package com.example.unit_converter.controllers;

import com.example.unit_converter.services.ConverterService;
import com.example.unit_converter.services.GeneralHelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Logger;

@Controller
public class LengthController {

    private final GeneralHelperService ghs;
    private final ConverterService converterService;
    private static final String VIEW_NAME = "length";
    private final Logger logger = Logger.getLogger(LengthController.class.getName());
    private boolean enteredInvalidInput = false;

    @Autowired
    public LengthController(GeneralHelperService ghs,
                            @Qualifier(VIEW_NAME) ConverterService converterService) {
        this.ghs = ghs;
        this.converterService = converterService;
    }

    @GetMapping("/" + VIEW_NAME)
    public String getLength(Model model) {
        ghs.viewSetter(model, false, enteredInvalidInput);
        return VIEW_NAME;
    }

    @PostMapping("/" + VIEW_NAME)
    public String postLength(@RequestParam String value,
                             @RequestParam String convertFrom,
                             @RequestParam String convertTo,
                             Model model) {

        double valueDouble, finalAnswer;

        // validate everything
        try {
            valueDouble = ghs.checkIfValidDouble(value);
            ghs.inputValidator(convertFrom, convertTo);
            finalAnswer = ghs.valueProcessor(convertFrom, convertTo, valueDouble, converterService);
        } catch(Exception e) {
            logger.warning("Values: " +
                    "[\"" + value + "\", \"" + convertFrom + "\", \"" + convertTo + "\"]" +
                    " not valid.");
            enteredInvalidInput = true;
            return "redirect:/" + VIEW_NAME;
        }

        // show answers
        enteredInvalidInput = false;
        ghs.viewSetter(model, true, enteredInvalidInput);
        ghs.answerSetter(model, valueDouble, finalAnswer, convertTo, convertFrom);

        return VIEW_NAME;
    }
}

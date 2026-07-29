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

@Controller
public class LengthController {

    private static final String viewName = "length";
    private final GeneralHelperService ghs;

    @Autowired
    public LengthController(GeneralHelperService ghs) {
        this.ghs = ghs;
    }

    @GetMapping("/" + viewName)
    public String getLength(Model model) {
        ghs.viewSetter(model, false);
        return viewName;
    }

    @PostMapping("/" + viewName)
    public String postLength(@RequestParam double value,
                             @RequestParam String convertFrom,
                             @RequestParam String convertTo,
                             Model model, @Qualifier(viewName)ConverterService converterService) {

        if (ghs.inputValidator(convertTo, convertFrom)) {
            return "redirect:/" + viewName;
        }
        double finalAnswer = ghs.valueProcessor(convertTo, convertFrom, value, converterService);
        ghs.viewSetter(model, true);
        ghs.answerSetter(model, value, finalAnswer, convertTo, convertFrom);

        return "/" + viewName;
    }
}

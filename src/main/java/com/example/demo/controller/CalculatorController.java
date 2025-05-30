package com.example.demo.controller;

import com.example.demo.exception.DivisionByZeroException;
import com.example.demo.validation.CalculationRequest;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Objects;

@Controller
public class CalculatorController {

    @GetMapping
    public String showForm(){
        return "calculator";
    }

    @PostMapping("/calculate")
    public String calculate(@Valid CalculationRequest request, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "calculator";
        }

        if(request.getB()==0 && Objects.equals(request.getOperation(), "divide"))
            throw new DivisionByZeroException();

        double result;

        switch (request.getOperation()) {
            case "add": result = request.getA() + request.getB(); break;
            case "subtract": result = request.getA() - request.getB(); break;
            case "multiply": result = request.getA() * request.getB(); break;
            case "divide": result = request.getA() / request.getB(); break;
            default:
                model.addAttribute("error", "Invalid operation");
                return "calculator";
        }

        model.addAttribute("result", result);
        return "result";
    }
}

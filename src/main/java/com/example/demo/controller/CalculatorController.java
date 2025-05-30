package com.example.demo.controller;

import com.example.demo.exception.DivisionByZeroException;
import com.example.demo.validation.CalculationRequest;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Controller
public class CalculatorController {
    private final MeterRegistry meterRegistry;

    public CalculatorController(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @GetMapping
    public String showForm(){
        return "calculator";
    }

    @GetMapping("/metrics")
    public String showMetrics(Model model){
        Map<String, Integer> metrics = new HashMap<>();
        meterRegistry.find("calculator.operations").counters().forEach(counter -> metrics
                .put(counter.getId().getTag("type"), (int) counter.count()));
        model.addAttribute("metrics", metrics);
        return "metrics";
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
            case "add":
                result = request.getA() + request.getB();
                meterRegistry.counter("calculator.operations", "type", "add").increment();
                break;
            case "subtract":
                result = request.getA() - request.getB();
                meterRegistry.counter("calculator.operations", "type", "sub").increment();
                break;
            case "multiply":
                result = request.getA() * request.getB();
                meterRegistry.counter("calculator.operations", "type", "mul").increment();
                break;
            case "divide":
                result = request.getA() / request.getB();
                meterRegistry.counter("calculator.operations", "type", "div").increment();
                break;
            default:
                model.addAttribute("error", "Invalid operation");
                return "calculator";
        }

        model.addAttribute("result", result);
        return "result";
    }
}

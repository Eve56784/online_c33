package com.example.demo.validation;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculationRequest {

    @NotNull(message="First number cannot be null")
    @Min(value=-1_000_000, message="First number must be greater than -1 million")
    @Max(value=1_000_000, message="First number must be less than 1 million")
    private double a;

    @NotNull(message="Second number cannot be null")
    @Min(value=-1_000_000, message="Second number must be greater than -1 million")
    @Max(value=1_000_000, message="Second number must be less than 1 million")
    private double b;

    @NotBlank(message = "Operation cannot be empty")
    private String operation;
}

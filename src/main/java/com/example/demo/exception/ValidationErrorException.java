package com.example.demo.exception;

public class ValidationErrorException extends RuntimeException{
    public ValidationErrorException(){
        super("ERROR: Division by zero");
    }
}

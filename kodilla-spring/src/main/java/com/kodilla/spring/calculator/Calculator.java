package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Calculator {

    @Autowired
    private Display display;

    public double add (double a, double b){
        final double result  = a + b;
        display.displayValue(result);
        return result;
    }

    public double sub (double a, double b){
        final double result  = a - b;
        display.displayValue(result);
        return result;
    }

    public double mul (double a, double b){
        final double result  = a * b;
        display.displayValue(result);
        return result;
    }

    public double div (double a, double b) throws DivisionByZeroException {
        final double result;
        if (b != 0) {
            result = a / b;
        } else {
            throw new DivisionByZeroException("Division by zero!");
        }
        display.displayValue(result);
        return result;
    }
}

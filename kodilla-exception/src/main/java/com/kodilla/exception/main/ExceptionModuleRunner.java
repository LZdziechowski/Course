package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.test.FirstChallenge;

import java.io.File;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

       /* final FileReader fileReader = new FileReader();
        fileReader.readFile();*/


        //--------------------  8.2  ---------------------//
        final FirstChallenge firstChallenge = new FirstChallenge();

        try {
            final double result = firstChallenge.divide(3, 0);
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Division by zero!");
        }
    }
}


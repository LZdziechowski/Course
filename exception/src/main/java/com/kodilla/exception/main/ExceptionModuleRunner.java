package com.kodilla.exception.main;

import com.kodilla.exception.io.FileReader;
import com.kodilla.exception.io.FileReaderException;
import com.kodilla.exception.io.FileReaderWithoutHandling;
import com.kodilla.exception.test.FirstChallenge;

import java.io.File;
import java.io.IOException;

public class ExceptionModuleRunner {

    public static void main(String[] args) {

       /*final FileReader fileReader = new FileReader();
       try {
           fileReader.readFile();
       } catch (FileReaderException e) {
           System.out.println("Problem while reading a file!");
       }*/

        /*FileReaderWithoutHandling fileReaderWithoutHandling = new FileReaderWithoutHandling();
        try {
            fileReaderWithoutHandling.readFile();
        } catch (IOException e) {
            System.out.println("Something go wrong! Error:  " + e);
        }*/


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



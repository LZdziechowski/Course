package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {

        String testUsername = "testUsername";
        String result;

        SimpleUser simpleUser = new SimpleUser(testUsername);
        result = simpleUser.getUsername();

        if (result.equals(testUsername)) {
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        ///////////////////////////////////////////////

        final int testNumber1 = 5;
        final int testNumber2 = 7;
        final int number1Addnumber2 = testNumber1 + testNumber2;
        final int number1SubtractNumber2 = testNumber1 - testNumber2;
        final int resultAddMethod;
        final int resultSubtractMethod;

        Calculator calculator = new Calculator();
        resultAddMethod = calculator.add(testNumber1, testNumber2);
        resultSubtractMethod = calculator.subtract(testNumber1, testNumber2);

        if (resultAddMethod == number1Addnumber2) {
            System.out.println("Add method OK");
        } else {
            System.out.println("Add method Error!");
        }

        if (resultSubtractMethod == number1SubtractNumber2) {
            System.out.println("Subtract method OK");
        } else {
            System.out.println("Subtract method Error!");
        }
    }
}

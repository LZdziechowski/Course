package com.kodilla.exception.test;

public class ExceptionHandling {

    private final SecondChallenge secondChallenge = new SecondChallenge();

    public void secondChallengeExceptionHandling (double a, double b) {

        try {
            secondChallenge.probablyIWillThrowException(a, b);
        } catch (Exception e) {
            System.out.println("Wrong number!");
        }
    }
}

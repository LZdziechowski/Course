package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.List;

public class OddNumbersExterminator {

    public List<Integer> exterminate(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            System.out.println("Empty list!");
            return numbers;
        } else {
            List<Integer> evenNumbers = new ArrayList<>();
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }
            return evenNumbers;
        }
    }
}
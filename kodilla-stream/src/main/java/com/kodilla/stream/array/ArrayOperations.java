package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {

    static double getAverage(int[] numbers) {
        final double result;

        IntStream.range(0, numbers.length)
                .forEach(n -> System.out.println(numbers[n]));

        result = IntStream.range(0, numbers.length)
                .mapToDouble(number -> (double)number)
                .average()
                .getAsDouble();

        return result;
    }
}

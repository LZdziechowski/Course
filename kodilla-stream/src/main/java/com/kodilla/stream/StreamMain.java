package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.beautifier.PoemDecorator;
import com.kodilla.stream.lambda.*;
import com.kodilla.stream.referene.FunctionalCalculator;

public class StreamMain {

    public static void main(String[] args) {
        /*final SaySomething saySomething = new SaySomething();
        saySomething.say();*/

        /*final Processor processor = new Processor();
        final ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        /*fianl Processor processor = new Processor();
        final Executor codeToExecute = () -> System.out.println("bbb");
        processor.execute(codeToExecute);*/

        /*final Processor processor = new Processor();
        processor.execute(() -> System.out.println("bbb"));*/

        /*final ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExspression(10,5, (a, b) -> a + b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a - b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a * b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a / b);

        expressionExecutor.executeExspression(10, 5, FunctionalCalculator::addAToB);
        expressionExecutor.executeExspression(10, 5, FunctionalCalculator::subAFromB);
        expressionExecutor.executeExspression(10, 5, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExspression(10, 5, FunctionalCalculator::divideAByB);*/

        final PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Text to Decorate", text -> text.toUpperCase());
        poemBeautifier.beautify("Text to Decorate", text -> "ABC" + text + "ABC");
        poemBeautifier.beautify("Text to Decorate", text -> text.toLowerCase());
        poemBeautifier.beautify("Text to Decorate", text -> {
            if (text.length() % 2 == 0) {
                return text + "- even number of characters";
            } else {
                return text + "- odd number of characters";
            }
        });
    }
}

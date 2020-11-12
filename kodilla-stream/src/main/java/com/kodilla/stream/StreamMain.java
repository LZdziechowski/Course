package com.kodilla.stream;

import com.kodilla.stream.lambda.*;

public class StreamMain {

    public static void main(String[] args) {
        SaySomething saySomething = new SaySomething();
        saySomething.say();

        /*Processor processor = new Processor();
        ExecuteSaySomething executeSaySomething = new ExecuteSaySomething();
        processor.execute(executeSaySomething);*/

        /*Processor processor = new Processor();
        Executor codeToExecute = () -> System.out.println("bbb");
        processor.execute(codeToExecute);*/

        /*Processor processor = new Processor();
        processor.execute(() -> System.out.println("bbb"));*/

        ExpressionExecutor expressionExecutor = new ExpressionExecutor();
        expressionExecutor.executeExspression(10,5, (a, b) -> a + b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a - b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a * b);
        expressionExecutor.executeExspression(10,5, (a, b) -> a / b);
    }
}

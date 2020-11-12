package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify (String text, PoemDecorator poemDecorator) {
        String result = poemDecorator.decorator(text);
        System.out.println(result);
    }
}

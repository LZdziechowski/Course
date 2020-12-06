package com.kodilla.spring.intro.shape;

public final class Triangle implements Shape {

    @Override
    public String draw() {
        System.out.println("This is Triangle.");
        return "This is Triangle";
    }
}

package com.kodilla.spring.shape;

import org.springframework.stereotype.Component;

@Component
public final class Circle implements Shape {

    @Override
    public String getShapeName() {
        return "This is Circle";
    }
}

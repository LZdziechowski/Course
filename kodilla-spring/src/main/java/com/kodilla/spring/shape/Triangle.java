package com.kodilla.spring.shape;

import org.springframework.stereotype.Component;

@Component
public final class Triangle implements Shape {

    @Override
    public String getShapeName() {
        return "This is Triangle";
    }
}

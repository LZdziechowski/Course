package com.kodilla.testing.shape;

public class CircleShape implements Shape {

    private final double radius;

    public CircleShape(double radius) {
        this.radius = radius;
    }

    @Override
    public String getShapeName() {
        return "Circle";
    }

    @Override
    public double getField() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return getShapeName();
    }
}

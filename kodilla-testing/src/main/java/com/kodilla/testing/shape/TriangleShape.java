package com.kodilla.testing.shape;

public class TriangleShape implements Shape {

    private final double lenght;
    private final double height;

    public TriangleShape(double lenght, double height) {
        this.lenght = lenght;
        this.height = height;
    }

    @Override
    public String getShapeName() {
        return "Triangle";
    }

    @Override
    public double getField() {
        return (lenght * height) / 2;
    }

    @Override
    public String toString() {
        return getShapeName();
    }
}

package com.kodilla.testing.shape;

public class SquareShape implements Shape {

    private final double side;

    public SquareShape(double side) {
        this.side = side;
    }

    @Override
    public String getShapeName() {
        return "Square";
    }

    @Override
    public double getField() {
        return Math.pow(side,2);
    }

    @Override
    public String toString() {
        return getShapeName();
    }

}

package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    List<Shape> shapesCollection = new ArrayList<>();

    public void addFigure(Shape shape) {
        shapesCollection.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (shapesCollection.contains(shape)) {
            shapesCollection.remove(shape);
            result = true;
        }
        return result;
    }

    public Shape getFigure(int n) {
        if (n >= 0 && n < shapesCollection.size()) {
            return shapesCollection.get(n);
        } else {
            return null;
        }
    }

    public String showFigures() {
        if (!shapesCollection.isEmpty()) {
            return shapesCollection.toString();
        } else {
            return null;
        }
    }
}

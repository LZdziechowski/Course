package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DrawerTestSuite {

    /*@Test
    void testDoDrawing() {
        //Given
        Drawer drawer = new Drawer();
        //When
        drawer.doDrawing();
        //Then
        //do nothing
    }*/

    @Test
    void testDoDrawingWithCircle() {
        //Given
        Circle circle = new Circle();
        //When
        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is Circle", result);
    }

    @Test
    void testDoDrawingWithTriangle() {
        //Given
        Triangle triangle = new Triangle();
        //When
        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();
        //Then
        assertEquals("This is Triangle", result);
    }
}

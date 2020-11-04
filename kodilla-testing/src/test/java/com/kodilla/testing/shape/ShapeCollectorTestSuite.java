package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Shape Collector Test Suite")
public class ShapeCollectorTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }

    @Nested
    @DisplayName("addFigure() method tests")
    class TestAddFigure {
        @DisplayName("when add figure with addFigure() method, getFigure() return the same figure")
        @Test
        void testAddFigure() {
            System.out.println("Test Add Figure");
            //Given
            final double testCircleRadius = 1;
            final Shape testShape = new CircleShape(testCircleRadius);
            final ShapeCollector shapeCollector = new ShapeCollector();
            //When
            shapeCollector.addFigure(testShape);
            //Then
            assertEquals(testShape, shapeCollector.getFigure(0));
        }
    }

    @Nested
    @DisplayName("removeFigure() method tests")
    class TestRemoveFigure {

        @DisplayName("when use removeFigure() method and give as parameter existing figure, used method return true and figure is removed")
        @Test
        void testRemoveFigure() {
            System.out.println("Test Remove Figure");
            //Given
            final double testCircleRadius = 1;
            final Shape testShape = new CircleShape(testCircleRadius);
            final ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(testShape);
            //When
            final boolean result = shapeCollector.removeFigure(testShape);
            //Then
            assertTrue(result);
            assertNull(shapeCollector.getFigure(0));
        }

        @DisplayName("when use removeFigure() method and give as parameter figure not exist, used method return false")
        @Test
        void testRemoveFigureNotExisting() {
            System.out.println("Test Remove Figure Not Existing");
            //Given
            final double testCircleRadius = 1;
            final Shape testShape = new CircleShape(testCircleRadius);
            final ShapeCollector shapeCollector = new ShapeCollector();
            //When
            final boolean result = shapeCollector.removeFigure(testShape);
            //Then
            assertFalse(result);
        }
    }

    @Nested
    @DisplayName("getFigure() method tests")
    class TestGetFigure {

        @DisplayName("when use getFigure() method, used method return figure on the position of the given parameter in the list")
        @Test
        void testGetFigure(){
            System.out.println("Test Get Figure");
            //Given
            final double testCircleRadius = 1;
            final Shape testShape = new CircleShape(testCircleRadius);
            final ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(testShape);
            //When
            final Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals(testShape, result);
        }

        @DisplayName("when use getFigure() method and give as parameter position in the list not exist, used method return null")
        @Test
        void testGetFigureNotExisting() {
            System.out.println("Test Get Figure Not Existing");
            //Given
            final ShapeCollector shapeCollector = new ShapeCollector();
            //When
            final Shape result = shapeCollector.getFigure(0);
            //Then
            assertEquals(null, result);
        }
    }

    @Nested
    @DisplayName("showFigure() method tests")
    class TestShowFigures {

        @DisplayName("when use showFigures(), method return names separated by comma")
        @Test
        void testShowFigures() {
            System.out.println("Test Show Figures");
            //Given
            final double testSize = 1;
            final Shape testCircleShape = new CircleShape(testSize);
            final Shape testSquareShape = new SquareShape(testSize);
            final ShapeCollector shapeCollector = new ShapeCollector();
            shapeCollector.addFigure(testCircleShape);
            shapeCollector.addFigure(testSquareShape);
            //When
            final String result = shapeCollector.showFigures();
            //Then
            assertEquals("[Circle, Square]", result);
        }

        @DisplayName("when use showFigures() and figures not exist, method return null")
        @Test
        void testShowFiguresNotExist() {
            System.out.println("Test Show Figures Not Exist");
            //Given
            final ShapeCollector shapeCollector = new ShapeCollector();
            //When
            final String result = shapeCollector.showFigures();
            //Then
            assertEquals(null, result);
        }
    }
}

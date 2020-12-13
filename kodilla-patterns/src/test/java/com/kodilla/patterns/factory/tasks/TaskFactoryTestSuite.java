package com.kodilla.patterns.factory.tasks;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskFactoryTestSuite {

    private int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of the tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished.");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter + ".");
    }

    @Test
    void testFactoryPaintingTask() {
        System.out.println("Test factory painting task.");
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task painting = factory.makeTask(TaskFactory.PAINTING);
        final boolean beforeExecute = painting.isTaskExecuted();
        painting.executeTask();
        final boolean afterExecute = painting.isTaskExecuted();
        //Then
        assertEquals("Paint the walls", painting.getTaskName());
        assertFalse(beforeExecute);
        assertTrue(afterExecute);
    }

    @Test
    void testFactoryDrivingTask() {
        System.out.println("Test factory driving task.");
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task driving = factory.makeTask(TaskFactory.DRIVING);
        final boolean beforeExecute = driving.isTaskExecuted();
        driving.executeTask();
        final boolean afterExecute = driving.isTaskExecuted();
        //Then
        assertEquals("Drive to the store", driving.getTaskName());
        assertFalse(beforeExecute);
        assertTrue(afterExecute);
    }

    @Test
    void testFactoryShoppingTask() {
        System.out.println("Test factory shopping task.");
        //Given
        TaskFactory factory = new TaskFactory();
        //When
        Task shopping = factory.makeTask(TaskFactory.SHOPPING);
        final boolean beforeExecute = shopping.isTaskExecuted();
        shopping.executeTask();
        final boolean afterExecute = shopping.isTaskExecuted();
        //Then
        assertEquals("Buy milk", shopping.getTaskName());
        assertFalse(beforeExecute);
        assertTrue(afterExecute);
    }
}

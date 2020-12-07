package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All test are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Preparing to execute test: #" + testCounter);
    }

    @Test
    void testTaskAdd() {
        System.out.println("Test: add task");
        //Given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToDoTask("Task to do");
        board.addInProgressTask("Task in progress");
        board.addDoneTask("Done task");
        //Then
        assertAll(
                () -> assertEquals("Task to do", board.getToDoList().getTasks().get(0)),
                () -> assertEquals("Task in progress", board.getInProgressList().getTasks().get(0)),
                () -> assertEquals("Done task", board.getDoneList().getTasks().get(0))
        );
    }

    @Test
    void testTaskMove() {
        System.out.println("Test: move task");
        //Give
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        //When
        board.addToDoTask("Task to move");
        board.moveTask("Task to move", board.getToDoList(), board.getInProgressList());
        //Then
        assertTrue(board.getToDoList().getTasks().isEmpty());
        assertEquals("Task to move", board.getInProgressList().getTasks().get(0));
    }

}

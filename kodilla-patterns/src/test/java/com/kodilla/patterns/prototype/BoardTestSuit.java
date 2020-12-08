package com.kodilla.patterns.prototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;

public class BoardTestSuit {

    @Test
    void testToString() {
        //Given
        //creating the TaskList for todos
        TaskList listToDo = new TaskList("To do tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listToDo.getTasks().add(new Task("To do task: " + n)));
        //creating teh TaskList for in progress
        TaskList listInProgres = new TaskList("In progress tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listInProgres.getTasks().add(new Task("In progress task: " + n)));
        //creating the TaskList for done tasks
        TaskList listDone = new TaskList("Done tasks");
        IntStream.iterate(1, n -> n + 1)
                .limit(10)
                .forEach(n -> listDone.getTasks().add(new Task("Done task: " + n)));
        //creating the board
        Board board = new Board("Project 1");
        //assigning the lists
        board.getLists().add(listToDo);
        board.getLists().add(listInProgres);
        board.getLists().add(listDone);
        System.out.println(board);

        //making a shallow clone of object board
        Board cloneBoard = null;
        try {
            cloneBoard = board.shallowCopy();
            cloneBoard.setName("Project 2");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(cloneBoard);

        //making a deep clone of object board
        Board deepCloneBoard = null;
        try {
            deepCloneBoard = board.deepCopy();
            deepCloneBoard.setName("Project 3");
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }
        System.out.println(deepCloneBoard);
        //When
        //NEW: removing elements
        board.getLists().remove(listToDo);
        //Then
        assertEquals(2, board.getLists().size());
        assertEquals(2, cloneBoard.getLists().size());
        assertEquals(3, deepCloneBoard.getLists().size());
        assertEquals(cloneBoard.getLists(), board.getLists());
        assertNotEquals(deepCloneBoard.getLists(), board.getLists());
    }
}

package com.kodilla.spring.portfolio;

public final class Board {

    private final TaskList toDoList;
    private final TaskList inProgressList;
    private final TaskList doneList;

    public Board(TaskList toDoList, TaskList inProgressList, TaskList doneList) {
        this.toDoList = toDoList;
        this.inProgressList = inProgressList;
        this.doneList = doneList;
    }

    public void addToDoTask(String task) {
        toDoList.addTask(task);
    }

    public void addInProgressTask(String task) {
        inProgressList.addTask(task);
    }

    public void addDoneTask(String task) {
        doneList.addTask(task);
    }

    public void moveTask(String task, TaskList fromList, TaskList toList) {
        if (fromList.removeTask(task)) {
            toList.addTask(task);
        }
    }

    public TaskList getToDoList() {
        return toDoList;
    }

    public TaskList getInProgressList() {
        return inProgressList;
    }

    public TaskList getDoneList() {
        return doneList;
    }
}

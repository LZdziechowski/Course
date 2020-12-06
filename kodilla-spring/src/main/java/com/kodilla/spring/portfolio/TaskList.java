package com.kodilla.spring.portfolio;

import java.util.ArrayList;
import java.util.List;

public final class TaskList {

    private final List<String> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String task) {
        tasks.add(task);
    }

    public boolean removeTask(String task) {
        if (tasks.contains(task)) {
            tasks.remove(task);
            return true;
        }
        return false;
    }
}


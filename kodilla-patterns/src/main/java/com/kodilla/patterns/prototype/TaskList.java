package com.kodilla.patterns.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskList {

    private final String name;
    private final List<Task> tasks = new ArrayList<>();

    public TaskList(String namel) {
        this.name = namel;
    }

    public String getName() {
        return name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "namel='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaskList taskList = (TaskList) o;

        if (!Objects.equals(name, taskList.name)) return false;
        return tasks.equals(taskList.tasks);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + tasks.hashCode();
        return result;
    }
}

package com.kodilla.patterns.prototype;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class Board extends Prototype<Board> {

    private String name;
    private Set<TaskList> lists = new HashSet<>();

    public Board(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TaskList> getLists() {
        return lists;
    }

    public Board shallowCopy() throws CloneNotSupportedException {
        return super.clone();
    }

    public Board deepCopy() throws CloneNotSupportedException {
        Board cloneBoard = super.clone();
        cloneBoard.lists = new HashSet<>();
        for (TaskList taskList : lists) {
            TaskList clonedList = new TaskList(taskList.getName());
            for (Task task : taskList.getTasks()) {
                clonedList.getTasks().add(task);
            }
            cloneBoard.getLists().add(clonedList);
        }
        return cloneBoard;
    }

    @Override
    public String toString() {
        return "Board{" +
                "name='" + name + '\'' +
                ", lists=" + lists +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        if (!Objects.equals(name, board.name)) return false;
        return lists.equals(board.lists);
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + lists.hashCode();
        return result;
    }
}

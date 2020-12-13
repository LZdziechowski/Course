package com.kodilla.patterns.factory.tasks;

public final class DrivingTask implements Task {

    private final String name;
    private final String where;
    private final String using;
    private boolean isExecute;

    public DrivingTask(final String name, final String where, final String using) {
        this.name = name;
        this.where = where;
        this.using = using;
        isExecute = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Executing task: " + name);
        isExecute = true;
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isTaskExecuted() {
        return isExecute;
    }
}

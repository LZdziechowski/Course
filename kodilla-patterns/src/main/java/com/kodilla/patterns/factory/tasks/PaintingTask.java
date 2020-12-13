package com.kodilla.patterns.factory.tasks;

public final class PaintingTask implements Task {

    private final String name;
    private final String color;
    private final String whatToPaint;
    private boolean isExecute;

    public PaintingTask(final String name, final String color, final String whatToPaint) {
        this.name = name;
        this.color = color;
        this.whatToPaint = whatToPaint;
        isExecute = false;
    }

    @Override
    public void executeTask() {
        System.out.println("Execute task: " + name);
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

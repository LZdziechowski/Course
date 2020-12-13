package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";
    public static final String SHOPPING = "SHOPPING";

    public final Task makeTask(final String taskClass) {
        switch (taskClass) {
            case PAINTING:
                return new PaintingTask("Paint the walls", "Blue", "Walls");
            case DRIVING:
                return new DrivingTask("Drive to the store", "Store", "Car");
            case SHOPPING:
                return new ShoppingTask("Buy milk", "Milk", 10);
            default:
                return null;
        }
    }
}

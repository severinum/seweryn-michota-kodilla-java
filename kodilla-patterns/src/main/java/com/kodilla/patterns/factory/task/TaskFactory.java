package com.kodilla.patterns.factory.task;

import com.kodilla.patterns.factory.Shape;

public class TaskFactory {
    public static final String SHOPPING_TASK = "SHOPPING_TASK";
    public static final String PAINTING_TASK = "PAINTING_TASK";
    public static final String DRIVING_TASK = "DRIVING_TASK";

    public final Task createTask(final String taskClass){
        switch (taskClass){
            case SHOPPING_TASK:
                return new ShoppingTask("Shopping Task", "Bread", 2);
            case PAINTING_TASK:
                return new PaintingTask("Painting Task", "Warm Yellow", "Kitchen walls");
            case DRIVING_TASK:
                return new DrivingTask("Driving Task", "Szczecin", "My Car");
            default:
                return null;
        }
    }
}

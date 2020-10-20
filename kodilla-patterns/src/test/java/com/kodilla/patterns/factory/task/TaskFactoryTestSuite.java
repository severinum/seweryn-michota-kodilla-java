package com.kodilla.patterns.factory.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskFactoryTestSuite {

    @Test
    void testFactoryDriving(){
        // given
        TaskFactory taskFactory = new TaskFactory();
        // when
        Task drivingTask = taskFactory.createTask(TaskFactory.DRIVING_TASK);
        // then
        assertEquals("Driving Task", drivingTask.getTaskName());
    }

    @Test
    void testPaintingFactory(){
        // given
        TaskFactory taskFactory = new TaskFactory();
        // when
        Task paintingTask = taskFactory.createTask(TaskFactory.PAINTING_TASK);
        // then
        assertEquals("Painting Task", paintingTask.getTaskName());
    }

    @Test
    void testShoppingFactory(){
        // given
        TaskFactory taskFactory = new TaskFactory();
        // when
        Task shoppingTask = taskFactory.createTask(TaskFactory.SHOPPING_TASK);
        // then
        assertEquals("Shopping Task", shoppingTask.getTaskName());
    }

}
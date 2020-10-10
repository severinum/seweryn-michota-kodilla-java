package com.kodilla.spring.portfolio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardTestSuite {

    @Test
    void testCreatedBoardsNames(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        // when
        String toDoName = board.getToDoList().getName();
        String inProgressName = board.getInProgressList().getName();
        String getDoneName = board.getDoneList().getName();
        // then
        assertEquals("To Do List", toDoName);
        assertEquals("In Progress List", inProgressName);
        assertEquals("Done List", getDoneName);
    }


    @Test
    void testIfBeansAreTaskLists(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        // when & then
        assertTrue(board.getToDoList() instanceof TaskList);
        assertTrue(board.getInProgressList() instanceof TaskList);
        assertTrue(board.getDoneList() instanceof TaskList);
    }

    @Test
    void testTaskAdd(){
        // given
        ApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
        Board board = context.getBean(Board.class);
        // when
        board.getToDoList().addTask("Pet the cat");
        int toDoListTasksCount = board.getToDoList().getTasks().size();

        board.getInProgressList().addTask("Paint the room");
        int inProgressTasksCount = board.getInProgressList().getTasks().size();

        board.getDoneList().addTask("Eat dinner");
        int getDoneTasksCount = board.getDoneList().getTasks().size();
        // then
        assertEquals(1, toDoListTasksCount );
        assertEquals(1, inProgressTasksCount );
        assertEquals(1, getDoneTasksCount );

        assertEquals("Pet the cat", board.getToDoList().getTasks().get(0));
        assertEquals("Paint the room", board.getInProgressList().getTasks().get(0));
        assertEquals("Eat dinner", board.getDoneList().getTasks().get(0));
    }

}
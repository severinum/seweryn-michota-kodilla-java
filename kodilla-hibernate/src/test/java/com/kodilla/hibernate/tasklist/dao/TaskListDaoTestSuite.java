package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.task.TaskFinancialDetails;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TaskListDaoTestSuite {
    @Autowired
    private TaskListDao taskListDao;
    private static final String LISTNAME = "To Do";
    private static final String LISTDESCRIPTION = "Lorem ipsum ...";

    @Test
    void testFindByListName(){
        // given
        TaskList taskList = new TaskList(LISTNAME, LISTDESCRIPTION);
        taskListDao.save(taskList);
        int id = taskList.getId();
        // when
        List<TaskList> readTaskList = taskListDao.findByListName(LISTNAME);
        // then
        assertEquals("To Do", readTaskList.get(0).getListName());
        // cleanUp
        taskListDao.deleteById(id);
    }


    @Test
    void testTaskListDaoSaveWithTasks(){
        // given
        Task task1 = new Task("Test: Learn Hibernate", 14);
        Task task2 = new Task("Test: Write some entities", 3);

        TaskFinancialDetails taskFinancialDetails1 = new TaskFinancialDetails(new BigDecimal(20), false);
        TaskFinancialDetails taskFinancialDetails2 = new TaskFinancialDetails(new BigDecimal(10), false);

        task1.setTaskFinancialDetails(taskFinancialDetails1);
        task2.setTaskFinancialDetails(taskFinancialDetails2);

        TaskList taskList = new TaskList(LISTNAME, "ToDo tasks");
        taskList.getTasks().add(task1);
        taskList.getTasks().add(task2);

        task1.setTaskList(taskList);
        task2.setTaskList(taskList);

        // when
        taskListDao.save(taskList);
        int id = taskList.getId();

        // then
        assertNotEquals(0, id);

        // clenUp
        taskListDao.deleteById(id);
    }

}
package com.kodilla.hibernate.tasklist.dao;

import com.kodilla.hibernate.task.Task;
import com.kodilla.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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



}
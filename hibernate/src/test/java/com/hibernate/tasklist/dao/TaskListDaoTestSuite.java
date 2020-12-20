package com.hibernate.tasklist.dao;

import com.hibernate.tasklist.TaskList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TaskListDaoTestSuite {

    @Autowired
    private TaskListDao taskListDao;

    @Test
    void testFindByListName(){
        System.out.println("Test findByListName() method");
        //Given
        final TaskList taskList = new TaskList("In progress", "Task current preformed");
        taskListDao.save(taskList);
        //When
        final String result = taskList.getListName();
        //Them
        Assertions.assertEquals("In progress", result);
        //CleanUp
        final int id = taskList.getId();
        taskListDao.deleteById(id);
    }
}

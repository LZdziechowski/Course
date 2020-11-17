package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class BoardTestSuite {

    private static int testCounter = 0;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Beginning of tests.");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("All tests are finished");
    }

    @BeforeEach
    public void beforeEach() {
        testCounter++;
        System.out.println("Prepare to execute test #" + testCounter);
    }

    private Board prepareTestData() {
        //users
        User user1 = new User("user1", "realName1");
        User user2 = new User("user2", "realName2");
        User user3 = new User("user3", "realName3");
        User user4 = new User("user4", "realName4");
        //tasks
        Task task1 = new Task("taskTitle1", "taskDescription1", user1, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));
        Task task2 = new Task("taskTitle2", "taskDescription2", user1, user2, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
        Task task3 = new Task("taskTitle3", "taskDescription3", user3, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(15));
        Task task4 = new Task("taskTitle4", "taskDescription4", user3, user2, LocalDate.now().minusDays(10), LocalDate.now().plusDays(25));
        Task task5 = new Task("taskTitle5", "taskDescription5", user4, user2, LocalDate.now(), LocalDate.now().plusDays(5));
        Task task6 = new Task("taskTitle6", "taskDescription6", user4, user2, LocalDate.now().minusDays(15), LocalDate.now().minusDays(2));
        //taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        Board project = new Board("projectName");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    void testAddTaskList() {
        System.out.println("Test Add Task List");
        //Given
        Board project = prepareTestData();
        //When
        //Then
        assertEquals(3, project.getTaskLists().size());
    }
}

package com.kodilla.stream.portfolio;

import org.junit.jupiter.api.*;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

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
        final User user1 = new User("user1", "realName1");
        final User user2 = new User("user2", "realName2");
        final User user3 = new User("user3", "realName3");
        final User user4 = new User("user4", "realName4");
        //tasks
        final Task task1 = new Task("taskTitle1", "taskDescription1", user1, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(30));
        final Task task2 = new Task("taskTitle2", "taskDescription2", user1, user2, LocalDate.now().minusDays(20), LocalDate.now().minusDays(5));
        final Task task3 = new Task("taskTitle3", "taskDescription3", user3, user2, LocalDate.now().minusDays(20), LocalDate.now().plusDays(15));
        final Task task4 = new Task("taskTitle4", "taskDescription4", user3, user2, LocalDate.now().minusDays(10), LocalDate.now().plusDays(25));
        final Task task5 = new Task("taskTitle5", "taskDescription5", user4, user2, LocalDate.now(), LocalDate.now().plusDays(5));
        final Task task6 = new Task("taskTitle6", "taskDescription6", user4, user2, LocalDate.now().minusDays(15), LocalDate.now().minusDays(2));
        //taskLists
        final TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);
        final TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);
        final TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);
        //board
        final Board project = new Board("projectName");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);
        return project;
    }

    @Test
    void testAddTaskList() {
        System.out.println("Test Add Task List");
        //Given
        final Board project = prepareTestData();
        //When
        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    @Test
    void testFindUsersTasks() {
        System.out.println("Test find users tasks");
        //Given
        final Board project = prepareTestData();
        //When
        final User user = new User("user1", "realName1");
        final List<Task> tasks = project.getTaskLists().stream()
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getAssignedUser().equals(user))
                .collect(toList());
        //Then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }

    @Test
    void testFindOutdatedTasks() {
        System.out.println("Test Find Outdated Tasks");
        //Given
        final Board project = prepareTestData();
        //When
        final List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        final List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
//                .filter(taskList -> taskList.getName().equals("To do") && taskList.getName().equals("In progress"))
                .flatMap(list -> list.getTasks().stream())
                .filter(task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());
        //Then
        assertEquals(1, tasks.size());
        assertEquals("taskTitle2", tasks.get(0).getTitle());
    }

    @Test
    void testFindLongTasks() {
        System.out.println("Test find Long tasks");
        //Given
        final Board project = prepareTestData();
        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        final long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(list -> list.getTasks().stream())
                .map(Task::getCreated)
                .filter(date -> date.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();
        //Then
        assertEquals(2, longTasks);
    }

    @Test
    void testAverageWorkingOnTasks() {
        System.out.println("Test Average Working On Tasks");
        //Given
        final Board project = prepareTestData();
        //When
        final List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        final List<Task> tasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap(taskList -> taskList.getTasks().stream())
                .collect(toList());
        final double averageNumberOfDaysAfterTaskStarts = IntStream.range(0, tasks.size())
                .map(n -> {
                    final Period period = Period.between(tasks.get(n).getCreated(), LocalDate.now());
                    return period.getDays();
                })
                .average()
                .getAsDouble();
        //Then
        assertEquals(10, averageNumberOfDaysAfterTaskStarts);
    }
}

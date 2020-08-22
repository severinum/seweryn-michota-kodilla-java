package com.kodilla.stream.portfolio;

import com.kodilla.stream.sand.SandStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toCollection;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

class BoardTestSuite {

    @Test
    @DisplayName("Add tasks lists to the project")
    void testAddTaskList() {
        //Given
        Board project = prepareTestData();
        //When

        //Then
        assertEquals(3, project.getTaskLists().size());
    }

    private Board prepareTestData(){
        // users
        User user1 = new User("developer1", "John Smith");
        User user2 = new User("projectmanager1", "Nina White");
        User user3 = new User("developer2", "Emilia Stephanson");
        User user4 = new User("developer3", "Konrad Bridge");

        //tasks
        Task task1 = new Task("Microservice for taking temperature",
                "Write and test the microservice taking\n" +
                        "the temperaure from external service",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(30));
        Task task2 = new Task("HQLs for analysis",
                "Prepare some HQL queries for analysis",
                user1,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().minusDays(5));
        Task task3 = new Task("Temperatures entity",
                "Prepare entity for temperatures",
                user3,
                user2,
                LocalDate.now().minusDays(20),
                LocalDate.now().plusDays(15));
        Task task4 = new Task("Own logger",
                "Refactor company logger to meet our needs",
                user3,
                user2,
                LocalDate.now().minusDays(10),
                LocalDate.now().plusDays(25));
        Task task5 = new Task("Optimize searching",
                "Archive data searching has to be optimized",
                user4,
                user2,
                LocalDate.now(),
                LocalDate.now().plusDays(5));
        Task task6 = new Task("Use Streams",
                "use Streams rather than for-loops in predictions",
                user4,
                user2,
                LocalDate.now().minusDays(15),
                LocalDate.now().minusDays(2));


        // taskLists
        TaskList taskListToDo = new TaskList("To do");
        taskListToDo.addTask(task1);
        taskListToDo.addTask(task3);

        TaskList taskListInProgress = new TaskList("In progress");
        taskListInProgress.addTask(task5);
        taskListInProgress.addTask(task4);
        taskListInProgress.addTask(task2);

        TaskList taskListDone = new TaskList("Done");
        taskListDone.addTask(task6);

        // board
        Board project = new Board("Project Weather Prediction");
        project.addTaskList(taskListToDo);
        project.addTaskList(taskListInProgress);
        project.addTaskList(taskListDone);

        return project;
    }


    @Test // wyszukanie zadan uzytkownika
    @DisplayName("Get users tasks")
    void testAddTaskListFindUsersTasks(){
        // given
        Board project  = prepareTestData();
        // when
        User user = new User("developer1", "John Smith");
        List<Task> tasks = project.getTaskLists().stream()
                .flatMap( list -> list.getTasks().stream())
                .filter( task -> task.getAssignedUser().equals(user))
                .collect(toList());
        // then
        assertEquals(2, tasks.size());
        assertEquals(user, tasks.get(0).getAssignedUser());
        assertEquals(user, tasks.get(1).getAssignedUser());
    }


    @Test // search for overdue tasks
    @DisplayName("Find all outdated tasks")
    void testAddTaskListFindOutdatedTasks(){
        // given
        Board project = prepareTestData();
        // when
        List<TaskList> undoneTasks = new ArrayList<>();
        undoneTasks.add(new TaskList("To do"));
        undoneTasks.add(new TaskList("In progress"));
        List<Task> tasks = project.getTaskLists().stream()
                .filter(undoneTasks::contains)
                .flatMap( taskList -> taskList.getTasks().stream())
                .filter( task -> task.getDeadline().isBefore(LocalDate.now()))
                .collect(toList());
        // then
        assertEquals(1, tasks.size());
        assertEquals("HQLs for analysis", tasks.get(0).getTitle());
    }


    @Test // ilość zadań wykonywanych od conajmniej 10 dni
    @DisplayName("Number of tasks realised fo at least last 10 day")
    void testAddTaskListFindLongTasks() {
        // given
        Board project = prepareTestData();
        // when
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        long longTasks = project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap( taskList -> taskList.getTasks().stream())
                .map(Task::getCreated)
                .filter( date -> date.compareTo(LocalDate.now().minusDays(10)) <= 0)
                .count();
    }


    /*
            Do mentora: nie wiem czy dobrze myślę i czy stream jest prawidłowy.
            Podaje dobry (chyba) wynik : 10
     */
    @DisplayName("HOMEWORK - find average time of task completion from 'In Progress' list")
    void testAddTaskListAverageWorkingOnTask(){
        // given
        Board project = prepareTestData();
        // when
        List<TaskList> inProgressTasks = new ArrayList<>();
        inProgressTasks.add(new TaskList("In progress"));
        double avg = IntStream.of(project.getTaskLists().stream()
                .filter(inProgressTasks::contains)
                .flatMap( taskList -> taskList.getTasks().stream())
                .map(Task::getCreated)
                .map(dateCreated ->  LocalDate.now().compareTo(dateCreated))
                .mapToInt(numDays -> numDays)
                .toArray())
                .average()
                .orElse(0);

        // then
        assertEquals(10, avg, 0.001);
    }
}







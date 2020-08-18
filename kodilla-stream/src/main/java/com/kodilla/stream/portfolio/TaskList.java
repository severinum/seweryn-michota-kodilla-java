package com.kodilla.stream.portfolio;

import java.util.LinkedList;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.Objects;
>>>>>>> origin/macbook

public final class TaskList {
    private final List<Task> tasks = new LinkedList<>();
    private final String name;

    public TaskList(final String name) {
        this.name = name;
    }

<<<<<<< HEAD
    public void addTask(Task task) {
        tasks.add(task);
    }

    public boolean removeTask(Task task) {
        return tasks.remove(task);
    }

    public List<Task> getTasks() {
        return new LinkedList<>(tasks);
    }

    public String getName() {
        return name;
=======
    public void addTask(Task task){
        tasks.add(task);
    }

    public boolean removeTask(Task task){
        return tasks.remove(task);
    }

    public List<Task> getTasks(){
        return new LinkedList<>(tasks);
    }

    public String getName(){
        return this.name;
>>>>>>> origin/macbook
    }

    @Override
    public String toString() {
        return "TaskList{" +
                "name='" + name + '\'' + ",\n" +
                "tasks=\n" + tasks + "\n" +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
<<<<<<< HEAD
        if (!(o instanceof TaskList)) return false;
        TaskList taskList = (TaskList) o;
        return name.equals(taskList.name);
    }
}
=======
        if (o == null || getClass() != o.getClass()) return false;
        TaskList taskList = (TaskList) o;
        return Objects.equals(name, taskList.name);
    }
}
>>>>>>> origin/macbook

package shedule.service;

import shedule.model.Priority;
import shedule.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskServiceImpl implements TaskService{
    List<Task>tasks;
    long id = 0;

    public TaskServiceImpl() {
        this.tasks = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public List<Task> getAll() {
        return tasks;
    }

    public Task createTask(long id, String deadLine, String name, String textTask, Priority priority) {
        return (new Task(id,java.time.LocalDate.now(),java.time.LocalTime.now(),deadLine,name,textTask,priority));

    }

    @Override
    public void deleteTask() {

    }

    @Override
    public void changeTask() {

    }
}

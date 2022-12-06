package shedule.service;

import shedule.model.Priority;
import shedule.model.Task;

import java.util.List;

public interface TaskService {
    List<Task>getAll();
//    void createTask(String deadLine, String name, String textTask, Priority priority);

    Task createTask(long id, String deadLine, String name, String textTask, Priority priority);

    void deleteTask();
    void changeTask();
}

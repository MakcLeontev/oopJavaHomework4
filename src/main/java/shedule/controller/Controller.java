package shedule.controller;

import shedule.model.Priority;
import shedule.model.Task;
import shedule.service.FileServiceCSV;
import shedule.service.FileServiceImpl;
import shedule.service.TaskService;
import shedule.service.TaskServiceImpl;
import shedule.view.View;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Controller {
    FileServiceImpl fileService = new FileServiceImpl("schedule.txt");
    TaskServiceImpl taskService = new TaskServiceImpl();
    FileServiceCSV fileServiceCSV = new FileServiceCSV("schedule.csv");


    public void createTask(String deadLine, String name, String textTask, Priority priority){
        List<String>tasks = fileService.readAllLines();
        long id = tasks.size();
        taskService.createTask(id+1,deadLine,name,textTask,priority);
        fileService.saveAllLines(listToString(taskService.getTasks()));
    }

    public void createCSV(String deadLine, String name, String textTask, Priority priority) throws IOException {
        List<Task>tasks = fileServiceCSV.readCSV();
        long id = tasks.size();
//        taskService.createTask(id+1,deadLine,name,textTask,priority);
//        fileServiceCSV.saveAllLines(listToString(taskService.getTasks()));
        fileServiceCSV.convertToCSV(taskService.createTask(id+1,deadLine,name,textTask,priority));
    }

    public void readCSV() throws IOException {
        showAllTaskCSV(fileServiceCSV.readCSV());
    }

    public void showAllTaskCSV(List<Task>tasks){
        for (Task item:tasks) {
            System.out.println(item);
        }
    }

    public List<String> listToString(List<Task>tasks){
        List<String>list = new ArrayList<>();
        for (Task item:tasks) {
            list.add(item.toString());
        }
        return list;
    }

    public void showAllTask(){
        List<String>taskList = fileServiceCSV.readAllLines();
        for (String item: taskList) {
            System.out.println(item);
        }
    }
}

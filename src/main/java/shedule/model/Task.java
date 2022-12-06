package shedule.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Task {
//    id, дату добавления записи, время добавления записи, дедлай задачи, ФИО автора
   private long taskId;
   private LocalDate addDate;
   private LocalTime addTime;
   private String deadLine;
   private String name;
   private String textTask;
   private Priority priority;

    public Task(long taskId,LocalDate addDate, LocalTime addTime, String deadLine, String name, String textTask,Priority priority) {
        this.taskId = taskId;
        this.addDate = addDate;
        this.addTime = addTime;
        this.deadLine = deadLine;
        this.name = name;
        this.textTask = textTask;
        this.priority = priority;
    }
    public Task(){

    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getTextTask() {
        return textTask;
    }

    public void setTextTask(String textTask) {
        this.textTask = textTask;
    }

    public long getTaskId() {
        return taskId;
    }

    public void setTaskId(long taskId) {
        this.taskId = taskId;
    }

    public LocalDate getAddDate() {
        return addDate;
    }

    public void setAddDate(LocalDate addDate) {
        this.addDate = addDate;
    }

    public LocalTime getAddTime() {
        return addTime;
    }

    public void setAddTime(LocalTime addTime) {
        this.addTime = addTime;
    }

    public String getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(String deadLine) {
        this.deadLine = deadLine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskId=" + taskId +
                ", addDate=" + addDate +
                ", addTime=" + addTime +
                ", deadLine=" + deadLine +
                ", name='" + name + '\'' +
                ", textTask='" + textTask + '\'' +
                ", priority=" + priority +
                '}';
    }
}

package shedule.view;

import shedule.controller.Controller;
import shedule.model.Priority;
import shedule.service.FileServiceImpl;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Scanner;

public class View {
    Controller controller = new Controller();
    public void run() throws IOException {
        Commands com = Commands.NONE;

        while (true) {
            try {
                String command = prompt("Введите команду (Create, List, Delete, Exit): \n");
                com = Commands.valueOf(command.toUpperCase());
            }catch(IllegalArgumentException e){
                System.out.println("Unknown command");
                continue;
            }
            if (com == Commands.EXIT) return;
            switch (com) {
                case CREATE:
                    try {
                        String name = prompt("Введите свое имя: ");
                        String textTask = prompt("Задача: ");
//                        LocalDateTime deadLine = LocalDateTime.parse(prompt("Крайний срок выполнения: "));
                        String deadline = prompt("Крайний срок выполнения: ");
                        Priority priority = Priority.valueOf(prompt("Приоритет выполнения:LOW, MEDIUM, HIGH "));
//                        controller.createTask(deadline,name,textTask,priority);
                        controller.createCSV(deadline,name,textTask,priority);
                    }catch (IllegalStateException e){
                        System.out.println(e.getMessage());
                        continue;

                    }
                    break;
//                case READ:
//                    String id = prompt("Идентификатор пользователя: ");
//                    try {
//                        User user = userController.readUser(id);
//                        System.out.println(user);
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                    break;
                case LIST:
                    controller.readCSV();
//                    controller.showAllTask();
//                    controller.showAllTaskCSV();
                    break;
//                case UPDATE:
//                    String firstName = prompt("Имя: ");
//                    String lastName = prompt("Фамилия: ");
//                    String phone = prompt("Номер телефона: ");
//                    String userID = prompt("Идентификатор пользователя");
//                    userController.editUser(new User(userID,firstName,lastName,phone));
            }
        }
    }

    private String prompt(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message);
        return in.nextLine();
    }




}

package shedule;

import shedule.controller.Controller;
import shedule.view.View;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        View view = new View();
        Controller controller = new Controller();
//        System.out.println(controller.getLastId());
        view.run();
//        controller.createCSV();

    }
}
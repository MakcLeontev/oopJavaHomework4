package shedule.service;

import au.com.bytecode.opencsv.CSVWriter;
import shedule.model.Priority;
import shedule.model.Task;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileServiceCSV extends FileServiceImpl{
    private String fileName;

    public FileServiceCSV(String fileName) {
        super(fileName);
        try (FileWriter writer = new FileWriter(fileName, true)) {
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void convertToCSV(Task task) {
        try (FileWriter writer = new FileWriter("schedule.csv",true)){
                StringBuilder sb = new StringBuilder();
                sb.append(task.getTaskId());
                sb.append(",");
                sb.append(task.getAddDate());
                sb.append(",");
                sb.append(task.getAddTime());
                sb.append(",");
                sb.append(task.getDeadLine());
                sb.append(",");
                sb.append(task.getName());
                sb.append(",");
                sb.append(task.getTextTask());
                sb.append(",");
                sb.append(task.getPriority());
                sb.append(System.lineSeparator());

                writer.write(sb.toString());
                writer.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Task> readCSV() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("schedule.csv"));

        String line = null;
        Scanner scanner = null;
        int index = 0;
        List<Task> tasks = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            Task task = new Task();
            scanner = new Scanner(line);
            scanner.useDelimiter(",");
            while (scanner.hasNext()) {
                String data = scanner.next();
                if (index == 0)
                    task.setTaskId(Long.parseLong(data));
                else if (index == 1)
                    task.setAddDate(LocalDate.parse(data));
                else if (index == 2)
                    task.setAddTime(LocalTime.parse(data));
                else if (index == 3)
                    task.setDeadLine(data);
                else if (index == 4)
                    task.setName(data);
                else if (index == 5)
                    task.setTextTask(data);
                else if (index == 6)
                    task.setPriority(Priority.valueOf(data));
                else
                    System.out.println("Некорректные данные::" + data);
                index++;
            }
            index = 0;
            tasks.add(task);
        }

        reader.close();

        return tasks;
    }

    @Override
    public List<String> readAllLines() {
        List<String> lines = new ArrayList<>();
        try {
            File file = new File("schedule.csv");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            if (line != null) {
                lines.add(line);
            }
            while (line != null) {
                // считываем остальные строки в цикле
                line = reader.readLine();
                if (line != null) {
                    lines.add(line);
                }
            }
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

//    @Override
//    public void saveAllLines(List<String> lines) throws IOException {
//
//    }

    @Override
    public void saveAllLines(List<String> lines)  {
        try (CSVWriter writer = new CSVWriter(new FileWriter("schedule.csv", true));) {
            for (String line : lines) {
                // запись всей строки
                writer.writeNext(new String[]{line});
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



}

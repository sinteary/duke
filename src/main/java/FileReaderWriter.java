import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class FileReaderWriter {
    private BufferedReader bufferedReader;
    String filePath = ".\\src\\main\\java\\data.txt";

    public FileReaderWriter() {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public Task FileToTask(String fileLine) {
        String[] taskInputs = fileLine.split("|");
        Task task = null;
        boolean isDone = (Integer.parseInt(taskInputs[1]) == 1 ? true : false);
        switch (taskInputs[0]) {
            case "T":
                task = new ToDo(taskInputs[2]);
                break;
            case "D":
                task = new Deadline(taskInputs[2], taskInputs[3]);
                break;
            case "E":
                task = new Event(taskInputs[2], taskInputs[3]);
                break;
        }
        if (isDone) {
            task.markAsDone();
        }
        return task;
    }

    public TaskList fileToTaskList() {
        TaskList taskList = new TaskList();
        try {
            String fileLine = this.bufferedReader.readLine();
            while (fileLine != null) {
                fileLine = bufferedReader.readLine();
                taskList.addTask(FileToTask(fileLine));
            }

        }
        catch (IOException e) {        }
        return taskList;
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Task.*;

public class TaskList {
    private ArrayList <Task> taskList = new ArrayList<>();
    private Printer printer;
    private String filePath = ".\\src\\main\\java\\data.txt";

    public TaskList() {
        loadTasksFromFile();
        this.printer = new Printer();
    }

    void loadTasksFromFile() {
        try {
            File dataFile = new File(filePath);
            Scanner dataFileReader = new Scanner(dataFile);
            String fileLine = null;
            while(dataFileReader.hasNext()) {
                fileLine = dataFileReader.nextLine();
                this.taskList.add(fileToTask(fileLine));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    void saveTasksToFile() throws IOException {
        File dataFile = new File(filePath);
        FileWriter fileWriter = new FileWriter(dataFile);
        String fileLine = null;
        for (Task task: this.taskList) {
            fileLine = taskToFile(task);
            fileWriter.write(fileLine);
        }
        fileWriter.close();
    }

    public Task fileToTask(String fileLine) {
        String[] taskInputs = fileLine.split(" \\| ");
        //System.out.println(taskInputs[0] + " " + taskInputs[1] + " " + taskInputs[2]);
        Task task = null;
        boolean isDone = (taskInputs[1].equals("1"));
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

    public String taskToFile (Task task) {
        String separator = " | ";
        String taskInitial = "";
        String taskDone = (task.isTaskDone() ? "1" : "0");
        String taskName = (task.getTaskName());
        String taskTime = "";
        switch (task.getTasktype()) {
            case TODO:
                taskInitial = "T";
                break;
            case EVENT:
                taskInitial = "E";
                taskTime = task.getTaskTime();
                break;
            case DEADLINE:
                taskInitial = "D";
                taskTime = task.getTaskTime();
                break;
        }
        return taskInitial + separator + taskDone + separator + taskName + separator + taskTime + "\n";
    }


    void addTask(Task task) {
        this.taskList.add(task);
    }

    int getNumberOfTasks() {
        return this.taskList.size();
    }

    ArrayList<Task> getTasks() {
        return this.taskList;
    }

    Task completeTask(int taskNumber) {
        this.taskList.get(taskNumber - 1).markAsDone();
        return this.taskList.get(taskNumber - 1);
    }
}

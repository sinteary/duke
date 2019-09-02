import Task.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadTasksFromFile() {
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            File dataFile = new File(filePath);
            Scanner dataFileReader = new Scanner(dataFile);
            String fileLine = null;
            while(dataFileReader.hasNext()) {
                fileLine = dataFileReader.nextLine();
                taskList.add(fileToTask(fileLine));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return taskList;
    }

    void saveTasksToFile(ArrayList<Task> taskList) throws IOException {
        File dataFile = new File(filePath);
        FileWriter fileWriter = new FileWriter(dataFile);
        String fileLine = null;
        for (Task task: taskList) {
            fileLine = taskToFile(task);
            fileWriter.write(fileLine);
        }
        fileWriter.close();
    }

    //Converts a string into Task
    public Task fileToTask(String fileLine) {
        String[] taskInputs = fileLine.split(" \\| ");
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

    //converts a string (in file format) to task
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

}

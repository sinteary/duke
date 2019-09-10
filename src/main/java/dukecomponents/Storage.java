package dukecomponents;

import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.ToDo;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class representing a storage space which saves the task list to the hard disk,
 * or loads the task list from the hard disk each time {@code Duke} is run.
 */
public class Storage {
    private String filePath;

    /**
     * Constructor for the {@code Storage} class.
     *
     * @param filePath The location of the file that stores the task list data.
     */
    public Storage(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads previously saved tasks from a file in the hard disk into a task list.
     *
     * @return An ArrayList of previously saved tasks loaded from the hard disk.
     */
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
            System.out.println("File not found :(");
        }
        return taskList;
    }

    /**
     * Saves the tasks in the task list into a file on the hard disk.
     *
     * @param taskList The task list to be saved onto the hard disk.
     * @throws IOException If the file in the hard disk cannot be found.
     */
    public void saveTasksToFile(ArrayList<Task> taskList) throws IOException {
        File dataFile = new File(filePath);
        FileWriter fileWriter = new FileWriter(dataFile);
        String fileLine = null;
        for (Task task: taskList) {
            fileLine = taskToFile(task);
            fileWriter.write(fileLine);
        }
        fileWriter.close();
    }

    /**
     * Returns a {@code Task} based on a line in the hard disk file which
     * describes it. Used when loading tasks from the hard disk to make sense of the
     * different formatting in the file.
     *
     * @param fileLine A line in the file which stores information about the task.
     * @return A {@code Task} with information as described by the fileLine.
     */
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

    /**
     * Returns a String which describes a {@code Task} in the task list in
     * a particular format used in the hard disk file.
     *
     * @param task Task to be converted into the file format.
     * @return A String representing the task in the file format.
     */
    public String taskToFile (Task task) {
        String separator = " | ";
        String taskInitial = "";
        String taskDone = (task.isTaskDone() ? "1" : "0");
        String taskName = (task.getTaskName());
        String taskTime = "";
        switch (task.getTaskType()) {
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
        default:
        }
        return taskInitial + separator + taskDone + separator + taskName + separator + taskTime + "\n";
    }

}

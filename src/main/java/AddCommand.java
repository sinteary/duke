import Task.*;

import java.io.IOException;

public class AddCommand extends Command {
    private Task taskToAdd;

    public AddCommand (String taskType, String taskDetails) {
        String taskName = "";
        String dateTime = "";
        switch (taskType) {
            case "todo":
                this.taskToAdd = new ToDo(taskDetails);
                break;
            case "event":
            case "deadline":
                SplitTaskNameAndTime splitInput = new SplitTaskNameAndTime(taskDetails);
                taskName = splitInput.getTaskName();
                dateTime = splitInput.getTime();
                switch (taskType) {
                    case "event":
                        this.taskToAdd = new Event(taskName, dateTime);
                        break;
                    case "deadline":
                        this.taskToAdd = new Deadline(taskName, dateTime);
                        break;
                }
                break;
        }
    }

    public void execute (TaskList taskList, UI ui, Storage storage) {
        taskList.addTask(this.taskToAdd);
        ui.printLines("Got it. I've added this task:",
        this.taskToAdd.toString(),
        "Now you have " + taskList.getNumberOfTasks() + " tasks in the list.");
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        }
        catch (IOException e) {
            ui.printLines("IO Exception");
        }
    }

}

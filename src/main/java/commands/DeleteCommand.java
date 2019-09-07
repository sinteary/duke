package commands;

import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;

import java.io.IOException;

public class DeleteCommand extends Command{
    private int taskNumber;

    public DeleteCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    public void execute (TaskList taskList, UI ui, Storage storage) {
        try {
            ui.printLines("Got it. I've removed this task:",
                taskList.getTask(this.taskNumber).toString(),
                "Now you have " + (taskList.getNumberOfTasks()-1) + " tasks in the list.");
            taskList.removeTask(this.taskNumber);
        } catch (IndexOutOfBoundsException e) {
            ui.printLines("Oops! This task does not exist and cannot be removed!");
        }
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        } catch (IOException e) {
            ui.printLines("IO Exception");
        }

    }
}

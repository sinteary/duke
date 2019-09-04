package Commands;

import dukeComponents.Storage;
import dukeComponents.TaskList;
import dukeComponents.UI;

import java.io.IOException;

public class DeleteCommand extends Command{
    private int taskNumber;

    public DeleteCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    public void execute (TaskList taskList, UI ui, Storage storage) {
        taskList.removeTask(taskNumber);
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        }
        catch (IOException e) {
            ui.printLines("IO Exception");
        }
        ui.printLines("Got it. I've removed this task:",
                taskList.getTask(taskNumber).toString(),
                "Now you have " + taskList.getNumberOfTasks() + " tasks in the list.");
    }
}

package Commands;

import dukeComponents.Storage;
import dukeComponents.TaskList;
import dukeComponents.UI;

public class DeleteCommand {
    private int taskNumber;

    public DeleteCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    public void execute (TaskList taskList, UI ui, Storage storage) {
        ui.printLines("Got it. I've removed this task:",
                taskList.getTask(taskNumber).toString(),
                "Now you have " + taskList.getNumberOfTasks() + " tasks in the list.");
        taskList.removeTask(taskNumber);
    }
}

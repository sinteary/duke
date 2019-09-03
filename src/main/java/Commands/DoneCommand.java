package Commands;
import dukeComponents.*;

import Task.Task;
import java.io.IOException;

public class DoneCommand extends Command{
    private int taskNumber;

    public DoneCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    public void execute (TaskList taskList, UI ui, Storage storage) {
        boolean isCompleted = true;
        Task task = null;
        try {
            task = taskList.completeTask(taskNumber);
        } catch (IndexOutOfBoundsException e) {
            isCompleted = false;
            ui.printLines("Task number " + taskNumber + " does not exist in the list!");
        }
        if (isCompleted) {
            ui.printLines("Nice! I've marked this task as done:", task.toString());
        }
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        }
        catch (IOException e) {
            ui.printLines("IO Exception");
        }
    }
}

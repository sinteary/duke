package commands;

import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.NoSuchTaskNumberException;
import java.io.IOException;
import tasks.Task;

public class DoneCommand extends Command{
    private int taskNumber;

    @Override
    public boolean equals(Object obj) {
        DoneCommand doneCommand = (DoneCommand) obj;
        return this.taskNumber == doneCommand.taskNumber;
    }

    public DoneCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    public void execute (TaskList taskList, UI ui, Storage storage) throws NoSuchTaskNumberException {
        Task task = null;
        try {
            task = taskList.completeTask(taskNumber);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchTaskNumberException(taskNumber);
        }
        ui.printLines("Nice! I've marked this task as done:", task.toString());
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        }
        catch (IOException e) {
            ui.printLines("IO Exception - unable to save :(");
        }
    }
}

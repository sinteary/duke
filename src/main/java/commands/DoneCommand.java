package commands;

import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.NoSuchTaskNumberException;
import java.io.IOException;
import tasks.Task;


/**
 * Represents a command that allows the mark an existing task from {@code Duke's} task list as completed.
 */
public class DoneCommand extends Command{
    private int taskNumber;

    /**
     * Constructor for the {@code DoneCommand} class.
     *
     * @param taskNumber Indicates which task number to mark as complete.
     */
    public DoneCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }


    /**
     * Checks if the DoneCommand is the same as another DoneCommand obj
     *
     * @param obj The DoneCommand to be compared against.
     * @return True if taskNumber of both DoneCommands is the same, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        DoneCommand doneCommand = (DoneCommand) obj;
        return this.taskNumber == doneCommand.taskNumber;
    }

    /**
     * Executes the command by marking the specified task in the task list as done, and saves the updated task
     * list to the hard disk. The user interface prints a confirmation.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     * @throws NoSuchTaskNumberException If the user tries to mark a task that does not exist as done.
     */
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

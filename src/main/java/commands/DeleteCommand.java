package commands;

import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.NoSuchTaskNumberException;
import java.io.IOException;

/**
 * Represents a command that allows the user to delete an existing task
 * from {@code Duke} task list.
 */
public class DeleteCommand extends Command{
    private int taskNumber;

    /**
     * Constructor for the {@code DeleteCommand} class. Takes in user input in the
     * form of a string, parses it to give an integer which is stored as the {@code taskNumber}.
     *
     * @param taskNumber indicates which task number to mark as complete
     */
    public DeleteCommand (String taskNumber) {
        this.taskNumber = Integer.parseInt(taskNumber);
    }

    /**
     * Executes the command to delete the task specified by the user from the task list,
     * and saves the updated task list to the hard disk. The user interface prints a confirmation.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     * @return Nothing.
     */
    public void execute (TaskList taskList, UI ui, Storage storage) throws NoSuchTaskNumberException {
        try {
            ui.printLines("Got it. I've removed this task:",
                taskList.getTask(this.taskNumber).toString(),
                "Now you have " + (taskList.getNumberOfTasks()-1) + " tasks in the list.");
            taskList.removeTask(this.taskNumber);
        } catch (IndexOutOfBoundsException e) {
            throw new NoSuchTaskNumberException(taskNumber);
        }
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        } catch (IOException e) {
            ui.printLines("IO Exception - cannot save to file :(");
        }

    }
}

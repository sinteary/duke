package commands;

import tasks.Task;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import java.util.ArrayList;

/**
 * Represents a command that allows the user to list all tasks in the task list.
 */
public class ListCommand extends Command {

    /**
     * Executes the command by printing the list of all the tasks in the list.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     */
    public void execute(TaskList taskList, UI ui, Storage storage) {
        ArrayList<Task> newTaskList = taskList.getAllTasks();
        ArrayList<String> tasksInString = new ArrayList<>();
        tasksInString.add("Here are the tasks in your list:");
        for (int index = 1; index <= newTaskList.size(); index++) {
            tasksInString.add(index + "." + newTaskList.get(index - 1));
        }
        ui.printLines(tasksInString.toArray(new String[0]));
    }
}

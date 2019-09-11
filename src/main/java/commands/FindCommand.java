package commands;

import tasks.Task;
import dukecomponents.*;
import java.util.ArrayList;

/**
 * Represents a command that allows the user to find tasks containing a certain keyword as
 * indicated by the user.
 */
public class FindCommand extends Command{
    private String keyword;

    /**
     * Constructor for the {@code FindCommand} class.
     *
     * @param keyword Indicates the keyword used to find matching tasks.
     */
    public FindCommand (String keyword) {
        this.keyword = keyword;
    }


    /**
     * Executes the command by finding the tasks with the matching keyword in the existing task list,
     * and printing the tasks and their details in the user interface.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     */
    public void execute (TaskList taskList, UI ui, Storage storage) {
        ArrayList<String> matchingTasksInString = new ArrayList<>();
        matchingTasksInString.add("Here are the matching tasks in your list:");
        ArrayList<Task> matchingTasks = taskList.getMatchingTasks(keyword);
        for (int i = 1; i <= matchingTasks.size(); i ++) {
            matchingTasksInString.add("" + (i) + "." + matchingTasks.get(i-1).toString());
        }
        ui.printLines(matchingTasksInString.toArray(new String[0]));
    }
}

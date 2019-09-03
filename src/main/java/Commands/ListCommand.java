package Commands;

import Task.Task;
import dukeComponents.Storage;
import dukeComponents.TaskList;
import dukeComponents.UI;

import java.util.ArrayList;

public class ListCommand extends Command {
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

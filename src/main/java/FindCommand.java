import Task.Task;

import java.util.ArrayList;

public class FindCommand extends Command{
    private String keyword;

    public FindCommand (String keyword) {
        this.keyword = keyword;
    }

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

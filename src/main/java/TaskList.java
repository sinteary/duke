import Task.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskList {
    private ArrayList <Task> taskList = new ArrayList<>();

    public TaskList(ArrayList<Task> loadedTasks) {
        this.taskList = loadedTasks;
    }

    public void clear() {
        this.taskList = new ArrayList<>();
    }

    public Task getTask(int taskNumber) {
        return this.taskList.get(taskNumber - 1);
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(int taskNumber) throws IndexOutOfBoundsException{
        this.taskList.remove(taskNumber - 1);
    }

    public int getNumberOfTasks() {
        return this.taskList.size();
    }

    public ArrayList<Task> getAllTasks() {
        return this.taskList;
    }

    public Task completeTask(int taskNumber) {
        this.taskList.get(taskNumber - 1).markAsDone();
        return this.taskList.get(taskNumber - 1);
    }

    ArrayList<Task> getMatchingTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList();
        for(int i = 0; i < this.taskList.size(); i ++) {
            String taskName = this.taskList.get(i).getTaskName();
            Scanner parseTaskName = new Scanner(taskName);
            while (parseTaskName.hasNext()) {
                String word = parseTaskName.next();
                if (word.equals(keyword)) {
                    matchingTasks.add(this.taskList.get(i));
                    break;
                }
            }
        }
        return matchingTasks;
    }

}

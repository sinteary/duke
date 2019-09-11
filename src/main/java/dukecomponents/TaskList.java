package dukecomponents;

import tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents a list of tasks.
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * Constructor for {@code TaskList} class. Creates a new {@code TaskList} with
     * files loaded from the hard disk.
     * @param loadedTasks A list of tasks previously saved onto the hard disk.
     */
    public TaskList(ArrayList<Task> loadedTasks) {
        this.taskList = loadedTasks;
    }

    /**
     * Returns a particular task based on the task number specified by the user.
     *
     * @param taskNumber The index of the task to be retrieved.
     * @return The task corresponding to the taskNumber in the task list.
     */
    public Task getTask(int taskNumber) {
        return this.taskList.get(taskNumber - 1);
    }

    /**
     * Adds a {@code Task} to the list.
     *
     * @param task Task to be added to the list.
     */
    public void addTask(Task task) {
        this.taskList.add(task);
    }

    /**
     * Deletes a {@code Task} as specified from the user from the list.
     *
     * @param taskNumber The index of the task to be removed.
     * @throws IndexOutOfBoundsException If the index of the task to be removed is invalid (i.e. negative value, or too large)
     */
    public void removeTask(int taskNumber) throws IndexOutOfBoundsException{
        this.taskList.remove(taskNumber - 1);
    }

    /**
     * Returns the total number of tasks in the list.
     * @return The total number of tasks in the task list.
     */
    public int getNumberOfTasks() {
        return this.taskList.size();
    }

    /**
     * Returns the entire task list.
     *
     * @return A list of all existing {@code Tasks}.
     */
    public ArrayList<Task> getAllTasks() {
        return this.taskList;
    }

    /**
     * Marks a task with the specified task number as done, and returns
     * the completed task.
     *
     * @param taskNumber The index of the task to be marked as done.
     * @return The completed task.
     */
    public Task completeTask(int taskNumber) {
        this.taskList.get(taskNumber - 1).markAsDone();
        return this.taskList.get(taskNumber - 1);
    }

    /**
     * Returns a list of tasks containing a keyword specified by the user.
     *
     * @param keyword The keyword used to find matching tasks.
     * @return A list of all tasks with the matching keyword.
     */
    public ArrayList<Task> getMatchingTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList();
        for (int i = 0; i < this.taskList.size(); i++) {
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

    /**
     * Clears all tasks in the list. Used for testing/debugging purposes.
     */
    public void clearAllTasks() {
        this.taskList = new ArrayList<>();
    }

}

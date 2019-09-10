package tasks;

/**
 * An abstract class representing a task.
 */
public abstract class Task {
    private String taskName;
    private boolean isDone;
    private TaskType tasktype;

    /**
     * Constructor for the {@code Task} class.
     *
     * @param taskName The name of the task.
     */
    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    /**
     * Marks the task as complete by changing the {@code isDone} boolean to true.
     */
    public void markAsDone() {
        this.isDone = true;
    }

    /**
     * Returns a String representing the completion status of the task.
     *
     * @return An icon (tick or cross) with a pair of brackets, indicating if the task has been completed.
     */
    public String getStatusIcon() {
        return ("[" + (this.isDone ? "\u2713" : "\u2718") + "]");
    }

    /**
     * Returns the name of the task.
     *
     * @return the taskName or name of the task.
     */
    public String getTaskName() {
        return this.taskName;
    }

    /**
     * Abstract method which returns the {@code TaskType} of the task.
     *
     * @return The {@code TaskType} of the task.
     */
    public abstract TaskType getTaskType();

    /**
     * An abstract method that returns A string representing the date and time details of the task.
     *
     * @return A string representing the date and time details of the task.
     */
    public abstract String getTaskDateTime();

    /**
     * Returns a boolean indicating if the task has been masked as done.
     *
     * @return True if the task has been marked as done ({@code isDone == true}, false otherwise.
     */
    public boolean isTaskDone() {
        return this.isDone;
    }

    /**
     * Returns a string descriptor of the task to be used when listing and displaying the tasks to the user.
     *
     * @return A string descriptor of the task in the following format: [Tick or cross] Task name.
     */
    @Override
    public String toString() {
        return String.format("%s %s", this.getStatusIcon(), this.taskName);
    }

}

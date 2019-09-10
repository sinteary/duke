package tasks;

/**
 * Represents a to do task with no specific time constraints.
 */
public class ToDo extends Task {
    private TaskType taskType = TaskType.TODO;

    /**
     * Constructor of the {@code ToDo} class.
     * Creates a to do task with a name.
     *
     * @param toDoName The name of the to do task.
     */
    public ToDo(String toDoName) {
        super(toDoName);
    }

    /**
     * Returns the task type.
     *
     * @return The {@code TaskType} of the event.
     */
    public TaskType getTaskType() {
        return this.taskType;
    }

    /**
     * Returns a string representing the date and time of the event.
     *
     * @return Null since to do tasks do not have a date and time.
     */
    @Override
    public String getTaskDateTime() {
        return null;
    }

    /**
     * Returns a string descriptor of the deadline to be used when listing and displaying the deadline to the user.
     *
     * @return A string descriptor in the following format: [T][tick or cross] Task name
     */
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

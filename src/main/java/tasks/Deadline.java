package tasks;

/**
 * Represents a deadline with a name, and the date and time of the deadline.
 */
public class Deadline extends Task {
    private TaskType taskType = TaskType.DEADLINE;
    private String by;

    /**
     * Constructor for the {@code Deadline} class.
     * Creates a deadline with a task name and a date and time.
     *
     * @param taskName The name of the deadline.
     * @param by The date and time of the deadline.
     */
    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
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
     * Returns a string representing the date and time of the deadline.
     *
     * @return A string representing the date and time of the deadline.
     */
    @Override
    public String getTaskDateTime() {
        return this.by;
    }

    /**
     * Returns a string descriptor of the deadline to be used when listing and displaying the deadline to the user.
     *
     * @return A string descriptor in the following format: [D][tick or cross] Task name (by: date and time)
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

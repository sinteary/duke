package tasks;

/**
 * Represents an event with a name and event date and time.
 */
public class Event extends Task {
    private TaskType taskType = TaskType.EVENT;
    private String at;

    /**
     * Constructor for the {@code Event} class.
     * Creates an event with an event name and a corresponding date and time.
     *
     * @param taskName The name of the event.
     * @param at The date and time of the event.
     */
    public Event(String taskName, String at) {
        super(taskName);
        this.at = at;
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
     * @return A string representing the date and time of the event.
     */
    @Override
    public String getTaskDateTime() {
        return this.at;
    }

    /**
     * Returns a string descriptor of the event to be used when listing and displaying the event to the user.
     *
     * @return A string descriptor in the following format: [E][tick or cross] Task name (at: date and time)
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}

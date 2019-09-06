package tasks;

public class Event extends Task {
    private TaskType taskType = TaskType.EVENT;
    private String at;

    public Event(String taskName, String at) {
        super(taskName);
        this.at = at;
    }

    public TaskType getTaskType() {
        return this.taskType;
    }

    @Override
    public String getTaskTime() {
        return this.at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + at + ")";
    }
}

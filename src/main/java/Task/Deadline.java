package Task;

public class Deadline extends Task {
    private TaskType taskType = TaskType.DEADLINE;
    private String by;

    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
    }

    public TaskType getTaskType() {
        return this.taskType;
    }

    @Override
    public String getTaskTime() {
        return this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
    }
}

public class Deadline extends Task {
    protected String by;

    public Deadline(String taskName, String by) {
        super(taskName);
        this.by = by;
        super.tasktype = TaskType.DEADLINE;
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

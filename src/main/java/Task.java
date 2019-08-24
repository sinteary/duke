public abstract class Task {
    protected String taskName;
    protected boolean isDone;
    protected TaskType tasktype;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
    }

    public void markAsDone() {
        this.isDone = true;
    }

    public String getStatusIcon() {
        return ("[" + (this.isDone ? "\u2713" : "\u2718") + "]");
    }

    public String getTaskName() {
        return this.taskName;
    }

    abstract String getType();

}

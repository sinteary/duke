public class Task {
    protected String taskName;
    protected boolean isDone;
    protected TaskType tasktype;

    public Task(String taskName) {
        this.taskName = taskName;
        this.isDone = false;
        this.tasktype = TaskType.TODO;
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

    public String getTaskDescription() { return (this.getStatusIcon() + " " + this.taskName); }

}

package Task;

public abstract class Task {
    private String taskName;
    private boolean isDone;
    private TaskType tasktype;

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

    public abstract TaskType getTaskType();

    public String getTaskTime() {
        return "";
    }

    public boolean isTaskDone() {
        return this.isDone;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.getStatusIcon(), this.taskName);
    }

}

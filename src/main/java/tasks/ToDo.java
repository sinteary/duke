package tasks;

public class ToDo extends Task {
    private TaskType taskType = TaskType.TODO;

    public ToDo(String toDoName) {
        super(toDoName);
    }

    public TaskType getTaskType() {
        return this.taskType;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

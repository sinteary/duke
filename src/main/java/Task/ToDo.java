package Task;

public class ToDo extends Task {
    private TaskType taskType = TaskType.TODO;

    public ToDo(String toDoName) {
        super(toDoName);
    }

    public TaskType getTasktype() {
        return this.taskType;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

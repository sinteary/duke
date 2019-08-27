public class ToDo extends Task {
    protected TaskType tasktype;

    public ToDo(String toDoName) {
        super(toDoName);
        super.setTaskType(TaskType.TODO);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

}

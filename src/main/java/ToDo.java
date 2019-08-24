public class ToDo extends Task {
    protected TaskType tasktype;

    public ToDo(String toDoName) {
        super(toDoName);
        super.tasktype = TaskType.T;
    }

    @Override
    String getType() {
        return "[T]";
    }
}

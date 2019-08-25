public class ToDo extends Task {
    protected TaskType tasktype;

    public ToDo(String toDoName) {
        super(toDoName);
        super.tasktype = TaskType.TODO;
    }

    @Override
    public String getTaskDescription() {
        return "[T]" + super.getTaskDescription();
    }

}

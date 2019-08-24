public class ToDo extends Task {
    private TaskType tasktype;

    public ToDo(String toDoName) {
        super(toDoName);
        this.tasktype = TaskType.TODO;
    }

}

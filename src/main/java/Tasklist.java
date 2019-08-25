import java.util.ArrayList;

public class TaskList {
    private ArrayList <Task> taskList;
    private Printer printer;

    TaskList() {
        this.taskList = new ArrayList<Task>();
        this.printer = new Printer();
    }

    void addTask(Task task) {
        this.taskList.add(task);
    }

    int getNumberOfTasks() {
        return this.taskList.size();
    }

    ArrayList<Task> getTasks() {
        return this.taskList;
    }

    Task completeTask(int taskNumber) {
        this.taskList.get(taskNumber - 1).markAsDone();
        return this.taskList.get(taskNumber - 1);
    }
}

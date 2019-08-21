import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tasklist {
    private ArrayList <Task> tasklist;
    private Printer printer;

    Tasklist() {
        this.tasklist = new ArrayList<Task>();
        this.printer = new Printer();
    }

    void addTask(String taskName) {
        this.tasklist.add(new Task(taskName));
        this.printer.printBorder();
        this.printer.print("added: " + taskName);
        this.printer.printBorder();
    }

    int numberOfTasks() {
        return this.tasklist.size();
    }

    void listTasks() {
        this.printer.printBorder();
        this.printer.print("Here are the tasks in your list:");
        for (int i = 1; i <= this.numberOfTasks(); i++) {
            this.printer.print(i + "." + this.tasklist.get(i-1).getStatusIcon() + " " + this.tasklist.get(i-1).taskName);
        }
        this.printer.printBorder();
    }

    void completeTask(int taskNumber) {
        this.tasklist.get(taskNumber - 1).completeTask();
        this.printer.printBorder();
        this.printer.print("Nice! I've marked this task as done:");
        this.printer.print(this.tasklist.get(taskNumber-1).getStatusIcon() + " " + this.tasklist.get(taskNumber-1).getTaskName());
        this.printer.printBorder();
    }
}

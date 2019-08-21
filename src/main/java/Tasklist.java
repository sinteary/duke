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
        for (int i = 1; i <= this.numberOfTasks(); i++) {
            this.printer.print(i + ". " + this.tasklist.get(i-1).taskName);
        }
        this.printer.printBorder();
    }
}

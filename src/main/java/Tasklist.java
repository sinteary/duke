import java.lang.reflect.Array;
import java.util.ArrayList;

public class Tasklist {
    private ArrayList <String> tasklist;
    private Printer printer;

    Tasklist() {
        this.tasklist = new ArrayList<String>();
        this.printer = new Printer();
    }

    void addTask(String taskName) {
        this.tasklist.add(taskName);
        this.printer.print("added: " + taskName);
    }

    int numberOfTasks() {
        return this.tasklist.size();
    }

    void listTasks() {
        for (int i = 1; i <= this.numberOfTasks(); i++) {
            System.out.println(i + ". " + this.tasklist.get(i-1));
        }
    }
}

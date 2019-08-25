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
        ToDo toDo = new ToDo(taskName);
        this.tasklist.add(toDo);
        this.printTaskDescription(toDo);
    }

    void addDeadline(String taskName, String deadlineDate) {
        Deadline deadline = new Deadline(taskName, deadlineDate);
        this.tasklist.add(deadline);
        this.printTaskDescription(deadline);
    }

    void printTaskDescription(Task task) {
        this.printer.printBorder();
        this.printer.print("Got it. I've added this task:");
        this.printer.print(task.getTaskDescription());
        this.printer.print("Now you have " + this.numberOfTasks() + " tasks in the list.");
        this.printer.printBorder();
    }

    int numberOfTasks() {
        return this.tasklist.size();
    }

    void listTasks() {
        this.printer.printBorder();
        this.printer.print("Here are the tasks in your list:");
        for (int i = 1; i <= this.numberOfTasks(); i++) {
            this.printer.print(i + ". " + this.tasklist.get(i-1).getTaskDescription());
        }
        this.printer.printBorder();
    }

    void completeTask(int taskNumber) {
        this.tasklist.get(taskNumber - 1).markAsDone();
        this.printer.printBorder();
        this.printer.print("Nice! I've marked this task as done:");
        this.printer.print(this.tasklist.get(taskNumber-1).getTaskDescription());
        this.printer.printBorder();
    }
}

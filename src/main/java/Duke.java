import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    Printer printer = new Printer();
    TaskList taskList = new TaskList();

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }

    private void run() {
        this.printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        String userInput;
        String description;
        Task task = null;
        while (continueReading) {
            userInput = scanner.next();
            description = scanner.nextLine().trim();
            switch (userInput) {
                case "bye":
                    this.printer.exit();
                    continueReading = false;
                    break;
                case "list":
                    this.listTasks();
                    break;
                case "done":
                    this.completeTask(Integer.parseInt(description));
                    break;
                case "todo":
                    task = new ToDo(description);
                    this.addTask(task);
                    break;
                case "deadline":
                case "event":
                    SplitInput splitInput = new SplitInput(description);
                    String taskName = splitInput.getTaskName();
                    String dateTime = splitInput.getTime();
                    if (userInput.equals("deadline")) {
                        task = new Deadline(taskName, dateTime);
                    } else {
                        task = new Event(taskName, dateTime);
                    }
                    this.addTask(task);
            }
        }
    }

    private void listTasks() {
        ArrayList<Task> taskList = this.taskList.getTasks();
        ArrayList<String> tasksInString = new ArrayList<>();
        tasksInString.add("Here are the tasks in your list:");
        for (int index = 1; index <= taskList.size(); index++) {
            tasksInString.add(index + "." + taskList.get(index - 1));
        }
        this.printer.printLines(tasksInString.toArray(new String[0]));
    }

    private void addTask(Task task){
        this.taskList.addTask(task);
        this.printer.printLines("Got it. I've added this task:",
                task.toString(),
                "Now you have " + this.taskList.getNumberOfTasks() + " tasks in the list.");
    }

    private void completeTask(int taskNumber) {
        boolean isCompleted = true;
        Task task = null;
        try {
            task = this.taskList.completeTask(taskNumber);
        } catch (IndexOutOfBoundsException e) {
            isCompleted = false;
            this.printer.print("Task " + taskNumber + " does not exist");
        }
        if (isCompleted) {
            this.printer.printLines("Nice! I've marked this task as done:", task.toString());
        }
    }

}

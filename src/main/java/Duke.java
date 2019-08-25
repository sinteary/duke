import java.util.Scanner;

public class Duke {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Tasklist tasklist = new Tasklist();

        printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        while (continueReading) {
            String userInput = scanner.next();
            switch (userInput) {
                case "bye":
                    continueReading = false;
                    break;
                case "list":
                    tasklist.listTasks();
                    break;
                case "done":
                    int taskNumber = scanner.nextInt();
                    try {
                        tasklist.completeTask(taskNumber);
                    } catch (IndexOutOfBoundsException e) {
                        printer.print("Task " + taskNumber + " does not exist");
                    }
                    break;
                case "todo":
                    String toDoName = scanner.nextLine();
                    tasklist.addTask(toDoName);
                    break;
                case "deadline":
                    String deadlineName = scanner.nextLine();
                    Scanner splitInput = new Scanner(deadlineName);
                    boolean deadlineFound = false;
                    String deadline = "";
                    String taskName = "";
                    while(splitInput.hasNext()) {
                        String next = splitInput.next();
                        if (deadlineFound) { deadline = deadline + " " + next; }
                        else {
                            if (next.charAt(0) == '/') {
                                deadlineFound = true;
                                deadline = deadline + next.substring(1);
                            }
                            else { taskName = taskName + " " + next; }
                        }
                    }
                    tasklist.addDeadline(taskName,deadline);
                    break;
            }
        }
        printer.exit();
    }
}

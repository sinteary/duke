import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Tasklist tasklist = new Tasklist();

        printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        while (continueReading) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "bye":
                    continueReading = false;
                    break;
                case "list":
                    tasklist.listTasks();
                    break;
                default:
                    String[] splitString = userInput.split(" ", 0);
                    if (splitString[0].equals("done")) {
                        int taskNumber = Integer.parseInt(splitString[1]);
                        try {
                            tasklist.completeTask(taskNumber);
                        } catch (IndexOutOfBoundsException e) {
                            printer.print("Task " + taskNumber + " does not exist");
                        }
                    }
                    else tasklist.addTask(userInput);
            }
        }
        printer.exit();
    }
}

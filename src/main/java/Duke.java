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
                    tasklist.addTask(userInput);
            }
        }
        printer.exit();
    }
}

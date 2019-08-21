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
                    if ((userInput.length() > 4) && (userInput.substring(0, 4).equals("done"))) {
                            Scanner sc = new Scanner(userInput);
                            String dummy = sc.next();
                            int taskNumber = sc.nextInt();
                            tasklist.completeTask(taskNumber);
                    }
                    else tasklist.addTask(userInput);
            }
        }
        printer.exit();
    }
}

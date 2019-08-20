import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        while (continueReading) {
            String userInput = scanner.nextLine();
            if (userInput.equals("bye")) continueReading = false;
            else printer.print(userInput);
        }
        printer.exit();
    }
}

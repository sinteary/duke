import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Printer printer = new Printer();
        printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        while (continueReading) {
            String userInput = scanner.nextLine();
            switch (userInput) {
                case "bye":
                    continueReading = false;
                    break;
                default:
                    printer.print(userInput);
            }
        }
        printer.exit();
    }
}

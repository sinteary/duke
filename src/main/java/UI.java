import java.util.Scanner;

public class UI {
    private Printer printer;
    private Scanner scanner;

    public UI() {
        this.printer = new Printer();
        this.scanner = new Scanner(System.in);
    }

    public void showWelcome() {
        this.printer.greet();
    }

    public String readCommand() {
        return this.scanner.nextLine();
    }

}

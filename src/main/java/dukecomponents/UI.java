package dukecomponents;

import java.util.Scanner;

/**
 * Represents the user interface that reads user input and displays messages for the user.
 */
public class UI {
    private Scanner scanner;

    String border = "     ____________________________________________________________";
    String indentation = "      ";

    /**
     * Constructor for the {@code UI} class.
     */
    public UI() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prints a single indented line border.
     */
    void printBorder() {
        System.out.println(border);
    }

    /**
     * Prints an indented message in a single line.
     *
     * @param message The message to be printed.
     */
    void print(String message) {
        System.out.println(indentation + message);
    }

    /**
     * Prints an indented and formatted message with a top and bottom border.
     *
     * @param lines The lines to be printed in between the border.
     */
    public void printLines(String... lines) {
        printBorder();
        for (String message : lines) {
            print(message);
        }
        printBorder();
    }

    /**
     * Prints a greeting for the user.
     */
    public void greet() {
        this.printLines("Hello I'm Duke", "What can I do for you?");
    }

    /**
     * Reads and returns the user input.
     *
     * @return A string containing the user input.
     */
    public String readCommand() {
        return this.scanner.nextLine();
    }

    /**
     * Prints an exit message for the user.
     */
    public void exit() {
        this.printLines("Bye. Hope to see you again soon!");
    }

}

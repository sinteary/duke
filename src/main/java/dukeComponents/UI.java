package dukeComponents;

import java.util.Scanner;

public class UI {
    private Scanner scanner;

    String border = "     ____________________________________________________________";
    String indentation = "      ";

    public UI() {
        this.scanner = new Scanner(System.in);
    }

    void printBorder() {
        System.out.println(border);
    }

    void print(String message) {
        System.out.println(indentation + message);
    }

    //To change List/ArrayList to primitive array: string list.toArray(new String[0])
    public void printLines(String... lines) {
        printBorder();
        for (String message : lines) {
            print(message);
        }
        printBorder();
    }

    public void greet() {
        this.printLines("Hello I'm Duke", "What can I do for you?");
    }

    public String readCommand() {
        return this.scanner.nextLine();
    }

    public void exit() {
        this.printLines("Bye. Hope to see you again soon!");
    }
}

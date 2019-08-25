public class Printer {
    String border = "     ____________________________________________________________";
    String indentation = "      ";

    void printBorder() {
        System.out.println(border);
    }

    void print(String message) {
        System.out.println(indentation + message);
    }

    //To change List/ArrayList to primitive array: string list.toArray(new String[0])
    void printLines(String... lines) {
        printBorder();
        for (String message : lines) {
            print(message);
        }
        printBorder();
    }

    void greet() {
        this.printLines("Hello I'm Duke", "What can I do for you?");
    }

    void exit() {
        this.printLines("Bye. Hope to see you again soon!");
    }
}

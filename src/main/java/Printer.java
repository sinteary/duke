public class Printer {
    String border = "     ____________________________________________________________";
    String indentation = "      ";

    void print(String message) {
        System.out.println(border);
        System.out.println(indentation + message);
        System.out.println(border);
    }

    void greet() {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        this.print("Hello! I'm Duke\n" + indentation + "What can I do for you?");
    }

    void exit() {
        this.print("Bye. Hope to see you again soon!");
    }
}

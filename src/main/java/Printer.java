public class Printer {
    String border = "     ____________________________________________________________";
    String indentation = "      ";

    void printBorder() {
        System.out.println(border);
    }

    void print(String message) {
        System.out.println(indentation + message);
    }

    void printToDo(Task task) {
        System.out.println(indentation + task.getType() + task.getStatusIcon() + " " + task.getTaskName());
    }

    void greet() {
        /*String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);*/
        this.printBorder();
        this.print("Hello! I'm Duke\n" + indentation + "What can I do for you?");
        this.printBorder();
    }

    void exit() {
        this.printBorder();
        this.print("Bye. Hope to see you again soon!");
        this.printBorder();
    }
}

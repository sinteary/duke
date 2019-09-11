import commands.Command;
import dukecomponents.Parser;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;
import java.util.NoSuchElementException;

/**
 * <h1>Duke Task Manager</h1>
 * Implements a task manager which can track 3 types of tasks.
 *
 * It contains a {@code UI} class to deal with user interactions,
 * a {@code TaskList} class to keep track of all tasks, a
 * {@code Storage} class to save and load the data. The {@code Parser}
 * class is used to make sense of the user input and carry out instructions.
 */
public class Duke {
    private UI ui;
    private TaskList taskList;
    private Storage storage;
    static String filePath = "data.txt";

    /**
     * Constructor for {@code Duke} class.
     *
     * @param filePath Indicates the path to a file in the hard disk where tasks are stored to or loaded from.
     */
    public Duke(String filePath) {
        this.ui = new UI();
        this.storage = new Storage(filePath);
        this.taskList = new TaskList(storage.loadTasksFromFile());
    }

    /**
     * This is the main method which makes use of Duke.run() method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        Duke duke = new Duke(filePath);
        duke.run();
    }

    /**
     * Runs the main process of Duke. Accepts input from the user
     * and executes user commands.
     */
    private void run() {
        this.ui.greet();
        boolean isExit = false;
        String userInput;

        while (!isExit) {
            userInput = this.ui.readCommand();
            try {
                Command c = Parser.parse(userInput);
                c.execute(this.taskList, this.ui, this.storage);
                isExit = c.isExit();
            } catch (DukeException e) {
                this.ui.printLines(e.getMessage());
            } catch (NoSuchElementException e) {
                this.ui.printLines("Please give me an instruction :)");
            }
        }
    }

}
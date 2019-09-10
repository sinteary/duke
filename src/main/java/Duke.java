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
 * <p></p>
 * It contains a <code>UI</code> class to deal with user interactions,
 * a <code>TaskList</code> class to keep track of all tasks, a
 * <code>Storage</code> class to save and load the data. The <code>Parser</code>
 * class is used to make sense of the user input and carry out instructions.
 */
public class Duke {
    private UI ui;
    private TaskList taskList;
    private Storage storage;
    static String filePath = "data.txt";

    public Duke(String filePath) {
        this.ui = new UI();
        this.storage = new Storage(filePath);
        this.taskList = new TaskList(storage.loadTasksFromFile());
    }

    /**
     * This is the main method which makes use of Duke.run() method.
     * @param args Unused.
     * @return Nothing.
     */
    public static void main(String[] args) {
        Duke duke = new Duke(filePath);
        duke.run();
    }

    /**
     * Runs the main process of Duke. Accepts input from the user
     * and executes user commands.
     * @return Nothing.
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
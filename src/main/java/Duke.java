import commands.Command;
import dukecomponents.Parser;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;
import java.util.NoSuchElementException;

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

    public static void main(String[] args) {
        Duke duke = new Duke(filePath);
        duke.run();
    }

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
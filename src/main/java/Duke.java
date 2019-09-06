import commands.Command;
import dukecomponents.Parser;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;
import java.text.ParseException;
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
            } catch (IndexOutOfBoundsException e) {
                this.ui.printLines("Oops! This task does not exist and cannot be removed!");
            } catch (NoSuchElementException e) {
                this.ui.printLines("Please give me an instruction :)");
            } catch (ParseException e) {
                this.ui.printLines("☹ OOPS!!! I don't recognize the date and time you entered.",
                "Please enter your date and time in this format: dd/MM/yyyy HHmm", "Example: 2/12/2019 1830 means 2 December 2019, 6.30pm");
            }
        }
    }

}
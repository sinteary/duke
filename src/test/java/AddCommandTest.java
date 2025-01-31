import static org.junit.Assert.assertEquals;

import commands.Command;
import dukecomponents.Parser;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class AddCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void execute_success() throws DukeException {
        Storage storage = new Storage("testdata");
        TaskList taskList = new TaskList(storage.loadTasksFromFile());
        Parser parser = new Parser();
        UI ui = new UI();

        String expected = "     ____________________________________________________________\r\n"
            + "      Got it. I've added this task:\r\n"
            + "      [T][✘] bake cake\r\n"
            + "      Now you have 1 tasks in the list.\r\n"
            + "     ____________________________________________________________\r\n"
            + "     ____________________________________________________________\r\n"
            + "      Got it. I've added this task:\r\n"
            + "      [E][✘] bake sale (at: 10 September 2019, 4.00 PM)\r\n"
            + "      Now you have 2 tasks in the list.\r\n"
            + "     ____________________________________________________________\r\n"
            + "     ____________________________________________________________\r\n"
            + "      Got it. I've added this task:\r\n"
            + "      [D][✘] finish cake recipe (by: 11 September 2019, 10.00 AM)\r\n"
            + "      Now you have 3 tasks in the list.\r\n"
            + "     ____________________________________________________________\r\n";

        Command c1 = parser.parse("todo bake cake");
        c1.execute(taskList, ui, storage);
        Command c2 = parser.parse("event bake sale /at 10/09/2019 1600");
        c2.execute(taskList, ui, storage);
        Command c3 = parser.parse("deadline finish cake recipe /by 11/09/2019 1000");
        c3.execute(taskList, ui, storage);

        assertEquals(expected, outContent.toString());

        try {
          storage.saveTasksToFile(new ArrayList<>());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

import static org.junit.Assert.assertEquals;

import commands.Command;
import dukecomponents.Parser;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Before;
import org.junit.Test;

public class AddCommandTest {
  String filePath = "testdata.txt";

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

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
        + "     ____________________________________________________________\r\n";
    Command c1 = parser.parse("todo bake cake");
    c1.execute(taskList, ui, storage);
    assertEquals(expected, outContent.toString());


  }


}

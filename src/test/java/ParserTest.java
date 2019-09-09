import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import commands.AddCommand;
import commands.Command;
import commands.DoneCommand;
import dukecomponents.Parser;
import dukeexceptions.DukeException;
import dukeexceptions.InvalidInputException;
import dukeexceptions.NoSuchTaskNumberException;
import dukeexceptions.NoTaskDescriptionException;
import dukeexceptions.NoTaskNumberSpecifiedException;
import java.text.ParseException;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {

  Parser parser = new Parser();

  String command1 = "todo Eat lunch";
  String command2 = "event Free lunch at Deck /at 10/09/2019 1200";
  String command3 = "deadline Deck the halls /by 10/09/2020 1500";

  @Test
  public void parse_addCommand_success ()
      throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException, ParseException, NoSuchTaskNumberException {
    Command testCommand1 = parser.parse(command1);
    assertEquals(testCommand1, new AddCommand("todo", "Eat lunch"));
    Command testCommand2 = parser.parse(command2);
    assertEquals(testCommand2, new AddCommand("event", "Free lunch at Deck /at 10/09/2019 1200"));
    Command testCommand3 = parser.parse(command3);
    assertEquals(testCommand3, new AddCommand("deadline", "Deck the halls /by 10/09/2020 1500"));
  }

  @ParameterizedTest
  @ValueSource(strings = {"todo","deadline","event"})
  public void parse_addCommand_noTaskDescriptionExceptionThrown (String command) throws DukeException, ParseException {
      DukeException exception = assertThrows(DukeException.class, () -> parser.parse(command));
      assertEquals(("OOPS!!! The description of a " + command + " cannot be empty."), exception.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"todo","deadline","event"})
  public void parse_addCommand_invalidDateTime (String command) throws DukeException, ParseException {
    DukeException exception = assertThrows(DukeException.class, () -> parser.parse(command));
    assertEquals(("OOPS!!! The description of a " + command + " cannot be empty."), exception.getMessage());
  }


  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "0", "-999"})
  public void parse_doneCommand_success(String command)
      throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException, ParseException, NoSuchTaskNumberException {
      assertEquals(new DoneCommand(command), parser.parse("done " + command));
  }





}

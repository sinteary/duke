import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import dukecomponents.Parser;
import commands.*;
import dukeexceptions.DukeException;
import dukeexceptions.InvalidInputException;
import dukeexceptions.NoTaskDescriptionException;
import dukeexceptions.NoTaskNumberSpecifiedException;
import java.text.ParseException;
import org.junit.Test;

public class ParserTest {

  Parser parser = new Parser();

  String command1 = "todo Eat lunch";
  String command2 = "event Free lunch at Deck /at 10/09/2019 1200";
  String command3 = "deadline Deck the halls /by 10/09/2020 1500";

  @Test
  public void parse_addCommand_success () throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException, ParseException {
    Command testCommand1 = parser.parse(command1);
    assertEquals(testCommand1, new AddCommand("todo", "Eat lunch"));
    Command testCommand2 = parser.parse(command2);
    assertEquals(testCommand2, new AddCommand("event", "Free lunch at Deck /at 10/09/2019 1200"));
    Command testCommand3 = parser.parse(command3);
    assertEquals(testCommand3, new AddCommand("deadline", "Deck the halls /by 10/09/2020 1500"));
  }

  int n = 3;
  String command4 = "todo";
  String command5 = "deadline";
  String command6 = "event";

  String[] exceptionCommands = {"todo","deadline","event"};

  @Test
  public void exceptionTesting () throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException, ParseException {
    for (int i = 0; i < n; n++) {
      DukeException exception = assertThrows(DukeException.class, () -> parser.parse(exceptionCommands[i]));
      assertEquals(("☹ OOPS!!! The description of a " + exceptionCommands[i] + " cannot be empty."), exception.getMessage());
    }
  }




}

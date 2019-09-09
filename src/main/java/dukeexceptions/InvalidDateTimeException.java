package dukeexceptions;

public class InvalidDateTimeException extends DukeException {

  public InvalidDateTimeException() {
    super("☹ OOPS!!! I don't recognize the date and time you entered.\n     Please enter your date and time in this format: dd/MM/yyyy HHmm"
        + "\n     Example: 2/12/2019 1830 means 2 December 2019, 6.30pm");
  }
}

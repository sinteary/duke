package dukeexceptions;

/**
 * A Duke exception thrown when the date and time entered by the user (for deadlines and events) are not in
 * the format of dd/MM/yyyy HHmm.
 */
public class InvalidDateTimeException extends DukeException {

  /**
   * Constructor for {@code InvalidDateTimeException}.
   */
  public InvalidDateTimeException() {
    super("☹ OOPS!!! I don't recognize the date and time you entered.\n     Please enter your date and time in this format: dd/MM/yyyy HHmm"
        + "\n     Example: 2/12/2019 1830 means 2 December 2019, 6.30pm");
  }
}

package dukeexceptions;

/**
 * A Duke exception thrown when the user inputs incomplete information regarding tasks.
 */
public class NoTaskDescriptionException extends DukeException {

  /**
   * Constructor for {@code NoTaskDescriptionException}.
   *
   * @param command The incomplete input given by the user: "todo", "deadline" or "event".
   */
  public NoTaskDescriptionException(String command) {
        super("OOPS!!! The description of a " + command + " cannot be empty.");
    }
}

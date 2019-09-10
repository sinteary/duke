package dukeexceptions;

/**
 * A Duke exception thrown when a user attempts to input a task number which does not exist,
 * such as negative numbers or numbers exceeding the total number of tasks in the list.
 */
public class NoSuchTaskNumberException extends DukeException {

  /**
   * Constructor for {@code NoSuchTaskNumberException}.
   *
   * @param taskNumber The invalid task number.
   */
  public NoSuchTaskNumberException(int taskNumber) {
        super("Task number " + taskNumber + " does not exist in the list!");
    }
}

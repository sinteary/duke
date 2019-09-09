package dukeexceptions;

public class NoSuchTaskNumberException extends DukeException {
  public NoSuchTaskNumberException(int taskNumber) {
    super("Task number " + taskNumber + " does not exist in the list!");
  }
}

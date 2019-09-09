package dukeexceptions;

public class NoTaskDescriptionException extends DukeException {
    public NoTaskDescriptionException(String command) {
                super("OOPS!!! The description of a " + command + " cannot be empty.");
    }
}

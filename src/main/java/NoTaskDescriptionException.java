public class NoTaskDescriptionException extends DukeException{
    NoTaskDescriptionException(String command) {
                super("☹ OOPS!!! The description of a " + command + " cannot be empty.");
    }
}

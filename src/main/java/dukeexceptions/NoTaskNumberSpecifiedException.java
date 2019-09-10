package dukeexceptions;

/**
 * A Duke exception thrown when the user does not specify a task number for certain commands such
 * as mark as done or delete.
 */
public class NoTaskNumberSpecifiedException extends DukeException {

    /**
     * Constructor for {@code NoTaskNumberSpecifiedException}.
     */
    public NoTaskNumberSpecifiedException() { super("OOPS!!! You did not specify the task number!"); }
}



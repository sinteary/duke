package dukeexceptions;

/**
 * A Duke exception thrown when the user inputs a command which is not recognised by Duke.
 */
public class InvalidInputException extends DukeException {

    /**
     * Constructor for {@code InvalidInputException}.
     */
    public InvalidInputException() {
        super("OOPS!!! I'm sorry, but I don't know what that means :-(");
    }
}

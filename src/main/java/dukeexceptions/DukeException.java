package dukeexceptions;

/**
 * A class of exceptions which are unique to Duke.
 */
public class DukeException extends Exception {

    /**
     * Constructor for {@code DukeException} class.
     *
     * @param errorMessage An error message corresponding to the exception encountered.
     */
    DukeException(String errorMessage) {
        super(errorMessage);
    }
}

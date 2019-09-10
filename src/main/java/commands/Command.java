package commands;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.DukeException;


/**
 * Abstract class which represents an instruction or command by the user.
 */
public abstract class Command {
    private boolean isExit;

    /**
     * Class Constructor for Command.
     * By default, it sets the boolean <code>isExit</code> to false.
     * The boolean {@code isExit} will be read by {@code Duke}.
     * If {@code isExit} is false, {@code Duke} will continue reading.
     * Else,it will stop reading and signal {@code Duke} to terminate.
     */
    public Command() {
        this.isExit = false;
    }

    public void setExit() {
        this.isExit = true;
    }

    /**
     * Returns the boolean value signalling for Duke to continue or stop
     * reading user input.
     *
     * @return False by default, true if ExitCommand has been executed.
     */
    public boolean isExit() {
        return this.isExit;
    }

    /**
     * Executes the command as specified by the user.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     * @throws DukeException If user input is invalid or insufficient.
     */
    public abstract void execute(TaskList taskList, UI ui, Storage storage)
        throws DukeException;

}

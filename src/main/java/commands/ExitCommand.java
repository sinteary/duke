package commands;
import dukecomponents.*;

/**
 * Represents a command which allows the user to stop running {@code Duke}.
 */
public class ExitCommand extends Command{

    /**
     * Executes the command which allows the user to exit {@code Duke}.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     */
    public void execute(TaskList taskList, UI ui, Storage storage) {
        super.setExit();
        ui.exit();
    }
}

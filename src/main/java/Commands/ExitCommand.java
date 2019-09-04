package Commands;
import dukeComponents.*;

public class ExitCommand extends Command{
    public void execute(TaskList taskList, UI ui, Storage storage) {
        super.setExit();
        ui.exit();
    }
}

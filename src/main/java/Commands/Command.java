package Commands;
import dukeComponents.*;


public abstract class Command {

    public abstract void execute(TaskList taskList, UI printer, Storage storage);

}

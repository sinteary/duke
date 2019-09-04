package Commands;
import dukeComponents.*;


public abstract class Command {
    private boolean isExit;

    public Command() {
        this.isExit = false;
    }

    public boolean isExit() {
        return this.isExit;
    }

    public void setExit() {
        this.isExit = true;
    }

    public abstract void execute(TaskList taskList, UI printer, Storage storage);

}

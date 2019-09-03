import Task.*;

public class AddCommand extends Command {
    private Task taskToAdd;

    public AddCommand (String taskType, String taskDetails) {
        String taskName = "";
        String dateTime = "";
        switch (taskType) {
            case "todo":
                this.taskToAdd = new ToDo(taskDetails);
                break;
            case "event":
            case "deadline":
                SplitTaskNameAndTime splitInput = new SplitTaskNameAndTime(taskDetails);
                taskName = splitInput.getTaskName();
                dateTime = splitInput.getTime();
                switch (taskType) {
                    case "event":
                        this.taskToAdd = new Event(taskName, dateTime);
                        break;
                    case "deadline":
                        this.taskToAdd = new Deadline(taskName, dateTime);
                        break;
                }
                break;
        }
    }

}

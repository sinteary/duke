package commands;

import dukecomponents.SplitTaskNameAndTime;
import dukecomponents.Storage;
import dukecomponents.TaskList;
import dukecomponents.UI;
import dukeexceptions.InvalidDateTimeException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import tasks.Deadline;
import tasks.Event;
import tasks.Task;
import tasks.ToDo;

/**
 * Represents a command which allows the user to add a task to the task list.
 */
public class AddCommand extends Command {
    private Task taskToAdd;
    private String taskName = "";
    private String dateTime = "";

  /**
   * Constructor for the {@code AddCommand} class.
   * The Task <code>taskToAdd</code> is set based on the user input.
   *
   * @param taskType Indicates the type of task to create: "todo","event" or "deadline".
   * @param taskDetails Contains the remaining task descriptors: task name and task date and time.
   * @throws InvalidDateTimeException A {@code DukeException} thrown when the input for date and time is not in the format dd/MM/yyy HHmm".
   */
    public AddCommand (String taskType, String taskDetails) throws InvalidDateTimeException {
        switch (taskType) {
        case "todo":
            this.taskToAdd = new ToDo(taskDetails);
        break;
        case "event":
        case "deadline":
            SplitTaskNameAndTime splitInput = new SplitTaskNameAndTime(taskDetails);
            taskName = splitInput.getTaskName();
            dateTime = splitInput.getDateTime();

            try {
                DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                Date parsed = inputFormat.parse(dateTime);
                DateFormat outputFormat = new SimpleDateFormat("dd MMMMM yyyy, h.mm a");
                dateTime = outputFormat.format(parsed);
            } catch (ParseException e) {
                throw new InvalidDateTimeException();
            }

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

    /**
     * Checks if the AddCommand is the same as another AddCommand object.
     *
     * @param obj AddCommand to be compared against.
     * @return True if both AddCommands are the have the same task name and date/time.
     */
    @Override
    public boolean equals(Object obj) {
        AddCommand addCommand = (AddCommand) obj;
        return this.taskName.equals(addCommand.taskName) && this.dateTime.equals(addCommand.dateTime);
    }

    /**
     * Executes the command by adding the task specified by the user.
     * to {@code Duke's} list of tasks, and prints a confirmation message informing the user that
     * the task was successfully added, as well as the total number of tasks in the list.
     *
     * @param taskList The task list containing all tasks.
     * @param ui The user interface.
     * @param storage The storage which saves to and loads from the hard disk.
     */
    public void execute (TaskList taskList, UI ui, Storage storage) {
        taskList.addTask(this.taskToAdd);
        try {
            storage.saveTasksToFile(taskList.getAllTasks());
        } catch (IOException e) {
            ui.printLines("IO Exception");
        }
        ui.printLines("Got it. I've added this task:",
        this.taskToAdd.toString(),
        "Now you have " + taskList.getNumberOfTasks() + " tasks in the list.");
    }

}

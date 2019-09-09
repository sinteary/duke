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

public class AddCommand extends Command {
    private Task taskToAdd;
    private String taskName = "";
    private String dateTime = "";

    @Override
    public boolean equals(Object obj) {
        AddCommand addCommand = (AddCommand) obj;
        return this.taskName.equals(addCommand.taskName) && this.dateTime.equals(addCommand.dateTime);
    }

    public AddCommand (String taskType, String taskDetails) throws InvalidDateTimeException {
        switch (taskType) {
        case "todo":
            this.taskToAdd = new ToDo(taskDetails);
        break;
        case "event":
        case "deadline":
            SplitTaskNameAndTime splitInput = new SplitTaskNameAndTime(taskDetails);
            taskName = splitInput.getTaskName();
            dateTime = splitInput.getTime();

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

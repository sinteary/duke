package dukecomponents;

import java.util.Scanner;

/**
 * A specially designed class used in <code>AddCommand</code> to make sense of the user input for
 * adding deadlines or events to the task list. It separates the task name and its corresponding
 * date and time.
 */
public class SplitTaskNameAndTime {
    private String taskName;
    private String dateTime;

    /**
     * Constructor for {@code SplitTaskNameAndTime} class.
     *
     * @param line User input which contains the task name, and task date and time.
     */
    public SplitTaskNameAndTime(String line) {
        Scanner splitInput = new Scanner(line);
        boolean dateTimeFound = false;
        String dateTime = "";
        String taskName = "";
        while (splitInput.hasNext()) {
            String next = splitInput.next();
            if (dateTimeFound) {
                dateTime = dateTime + " " + next;
            }
            else {
                if (next.equals("/by") || next.equals("/at")) {
                    dateTimeFound = true;
                }
                else { taskName = taskName + " " + next; }
            }
        }
        this.taskName = taskName.trim();
        this.dateTime = dateTime.trim();
    }

    /**
     * Returns the task name, parsed from the user input
     *
     * @return The task name.
     */
    public String getTaskName() {
        return this.taskName;
    }

    /**
     * Returns the date and time, parsed from the user input.
     *
     * @return The date and time information of the task.
     */
    public String getDateTime() {
        return this.dateTime;
    }

}

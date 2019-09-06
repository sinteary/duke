package dukecomponents;

import java.util.Scanner;

public class SplitTaskNameAndTime {
    private String taskName;
    private String time;

    public SplitTaskNameAndTime(String line) {
        Scanner splitInput = new Scanner(line);
        boolean timeFound = false;
        String time = "";
        String taskName = "";
        while (splitInput.hasNext()) {
            String next = splitInput.next();
            if (timeFound) {
                time = time + " " + next;
            }
            else {
                if (next.equals("/by") || next.equals("/at")) {
                    timeFound = true;
                }
                else { taskName = taskName + " " + next; }
            }
        }
        this.taskName = taskName.trim();
        this.time = time.trim();
    }

    public String getTaskName() {
        return this.taskName;
    }

    public String getTime() {
        return this.time;
    }

}

import java.util.Scanner;

public class SplitInput {
    private String taskName;
    private String time;

    public SplitInput(String line) {
        Scanner splitInput = new Scanner(line);
        boolean timeFound = false;
        String time = "";
        String taskName = "";
        while(splitInput.hasNext()) {
            String next = splitInput.next();
            if (timeFound) { time = time + " " + next; }
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

    String getTaskName() {
        return this.taskName;
    }

    String getTime() {
        return this.time;
    }

}

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Duke {
    Printer printer = new Printer();
    TaskList taskList = new TaskList();

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }

    private void run() {
        this.printer.greet();
        Scanner scanner = new Scanner(System.in);
        boolean continueReading = true;
        String userInput;
        String command; String taskDetails;
        Task task = null;

        while (continueReading) {
            userInput = scanner.nextLine();
            try {
                InputProcessor inputProcessor = new InputProcessor(userInput);
                command = inputProcessor.getCommand();
                taskDetails = inputProcessor.getDetails();
                switch (command) {
                    case "bye":
                        this.printer.exit();
                        taskList.saveTasksToFile();
                        continueReading = false;
                        break;
                    case "list":
                        this.listTasks();
                        break;
                    case "done":
                        this.completeTask(Integer.parseInt(taskDetails));
                        break;
                    case "todo":
                        task = new ToDo(taskDetails);
                        this.addTask(task);
                        break;
                    case "deadline":
                    case "event":
                        SplitTaskNameAndTime splitTaskNameAndTime = new SplitTaskNameAndTime(taskDetails);
                        String taskName = splitTaskNameAndTime.getTaskName();
                        String dateTime = splitTaskNameAndTime.getTime();
                        try {
                            DateFormat inputFormat = new SimpleDateFormat("dd/mm/yyyy HHmm");
                            Date parsed = inputFormat.parse(dateTime);
                            DateFormat outputFormat = new SimpleDateFormat("dd MMMM yyyy, hh a");
                            dateTime = outputFormat.format(parsed);
                        }
                        catch (ParseException e) {
                            dateTime = splitTaskNameAndTime.getTime();
                        }

                        if (command.equals("deadline")) {
                            task = new Deadline(taskName, dateTime);
                        } else {
                            task = new Event(taskName, dateTime);
                        }
                        this.addTask(task);
                }
                this.taskList.saveTasksToFile();
            }
            catch (InvalidInputException e) {
                this.printer.print(e.getMessage());
            }
            catch (NoTaskNumberSpecifiedException e) {
                this.printer.print(e.getMessage());
            }
            catch (NoTaskDescriptionException e) {
                this.printer.print(e.getMessage());
            }
            catch (IOException e) {
                this.printer.print(e.getMessage());
            }
        }
    }

    private void listTasks() {
        ArrayList<Task> taskList = this.taskList.getTasks();
        ArrayList<String> tasksInString = new ArrayList<>();
        tasksInString.add("Here are the tasks in your list:");
        for (int index = 1; index <= taskList.size(); index++) {
            tasksInString.add(index + "." + taskList.get(index - 1));
        }
        this.printer.printLines(tasksInString.toArray(new String[0]));
    }

    private void addTask(Task task){
        this.taskList.addTask(task);
        this.printer.printLines("Got it. I've added this task:",
                task.toString(),
                "Now you have " + this.taskList.getNumberOfTasks() + " tasks in the list.");
    }

    private void completeTask(int taskNumber) {
        boolean isCompleted = true;
        Task task = null;
        try {
            task = this.taskList.completeTask(taskNumber);
        } catch (IndexOutOfBoundsException e) {
            isCompleted = false;
            this.printer.print("Task number " + taskNumber + " does not exist in the list!");
        }
        if (isCompleted) {
            this.printer.printLines("Nice! I've marked this task as done:", task.toString());
        }
    }

}

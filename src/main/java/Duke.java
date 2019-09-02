import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Task.Deadline;
import Task.Event;
import Task.Task;
import Task.ToDo;

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
                    case "delete":
                        this.removeTask(Integer.parseInt(taskDetails));
                        break;
                    case "find":
                        this.findTasksByKeyword(taskDetails);
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
                            DateFormat inputFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
                            Date parsed = inputFormat.parse(dateTime);
                            DateFormat outputFormat = new SimpleDateFormat("dd MMMMM yyyy, h.mm a");
                            dateTime = outputFormat.format(parsed);
                            if (command.equals("deadline")) {
                                task = new Deadline(taskName, dateTime);
                            } else {
                                task = new Event(taskName, dateTime);
                            }
                            this.addTask(task);
                        }
                        catch (ParseException e) {
                            this.printer.printLines("☹ OOPS!!! I don't recognize the date and time you entered.",
                                    "Please enter your date and time in this format: dd/MM/yyyy HHmm", "Example: 2/12/2019 1830 means 2 December 2019, 6.30pm");
                        }
                        break;
                 }
                this.taskList.saveTasksToFile();
            }

            catch (NoTaskNumberSpecifiedException e) {
                this.printer.printLines(e.getMessage());
            }
            catch (NoTaskDescriptionException e) {
                this.printer.printLines(e.getMessage());
            }
            catch (IndexOutOfBoundsException e) {
                this.printer.printLines("Oops! This task does not exist and cannot be removed!");
            }
            catch (NoSuchElementException e) {
                this.printer.printLines("Please give me an instruction :)");
            }
            catch (InvalidInputException e) {
                this.printer.printLines(e.getMessage());
            }
            catch (IOException e) {
                this.printer.printLines(e.getMessage());
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

    private void removeTask(int taskNumber) {
        this.printer.printLines("Got it. I've removed this task:",
        this.taskList.getTask(taskNumber).toString(),
        "Now you have " + this.taskList.getNumberOfTasks() + " tasks in the list.");
        this.taskList.removeTask(taskNumber);
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

    private void findTasksByKeyword(String keyword) {
        ArrayList<String> matchingTasksInString = new ArrayList<>();
        matchingTasksInString.add("Here are the matching tasks in your list:");
        ArrayList<Task> matchingTasks = this.taskList.getMatchingTasks(keyword);
        for (int i = 1; i <= matchingTasks.size(); i ++) {
            matchingTasksInString.add("" + (i) + "." + matchingTasks.get(i-1).toString());
        }
        this.printer.printLines(matchingTasksInString.toArray(new String[0]));
    }


}

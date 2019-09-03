package dukeComponents;

import Commands.*;
import dukeExceptions.InvalidInputException;
import dukeExceptions.NoTaskDescriptionException;
import dukeExceptions.NoTaskNumberSpecifiedException;

import java.util.Scanner;

public class Parser {
    private Command command;

    public Command parse(String fullCommand) throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException {
        Scanner scanner = new Scanner(fullCommand);
        String userCommand = scanner.next();
        String commandDetails = "";

        switch (userCommand) {
            case "todo":
            case "event":
            case "deadline":
            case "done":
            case "delete":
            case "find":
                if (scanner.hasNext()) {
                    commandDetails = scanner.nextLine().trim();
                }
                else {
                    switch (userCommand) {
                        case "delete":
                        case "done":
                            throw new NoTaskNumberSpecifiedException();
                        case "find":
                            //throw new NoKeywordSpecifiedException();
                        default:
                            throw new NoTaskDescriptionException(userCommand);
                    }
                }
                switch (userCommand) {
                    case "todo":
                    case "event":
                    case "deadline":
                        this.command = new AddCommand(userCommand, commandDetails);
                        break;
                    case "done":
                        this.command = new DoneCommand(commandDetails);
                        break;
                    case "delete":
                        this.command = new DeleteCommand(commandDetails);
                        break;
                    case "find":
                        this.command = new FindCommand(commandDetails);
                        break;
                }
                break;
            case "list":
                this.command = new ListCommand();
                break;
            case "bye":
                this.command = new ExitCommand();
                break;
            default:
                throw new InvalidInputException();
        }
        return this.command;
    }

}

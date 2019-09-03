import DukeExceptions.InvalidInputException;
import DukeExceptions.NoTaskDescriptionException;
import DukeExceptions.NoTaskNumberSpecifiedException;

import java.util.Scanner;

public class Parser {

    private Command command;

    public Command parse(String fullCommand) throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException {
        String userCommand, commandDetails;
        Scanner scanner = new Scanner(fullCommand);

        userCommand = scanner.next();
        commandDetails = "";
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
                }
                break;
            case "list":
            case "bye":
                break;
            default:
                throw new InvalidInputException();
        }
        return this.command;
    }

}

package dukecomponents;

import commands.AddCommand;
import commands.Command;
import commands.DeleteCommand;
import commands.DoneCommand;
import commands.ExitCommand;
import commands.FindCommand;
import commands.ListCommand;
import dukeexceptions.DukeException;
import dukeexceptions.InvalidInputException;
import dukeexceptions.NoTaskDescriptionException;
import dukeexceptions.NoTaskNumberSpecifiedException;
import java.util.Scanner;

/**
 * A class which helps to make sense of the user input by separating the command
 * type and command details, and creating a corresponding command which can be
 * executed to fulfill the user's instruction.
 */
public class Parser {
    private static Command command;

    /**
     * Makes sense of the user input to return a {@code Command} which corresponds
     * to the user's instruction.
     *
     * @param fullCommand A string representing the full line of user input.
     * @return A {@code Command} corresponding to the instruction given by the user.
     * @throws DukeException If the user input is invalid or incomplete.
     */
    public static Command parse(String fullCommand) throws DukeException {
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
                    command = new AddCommand(userCommand, commandDetails);
                break;
                case "done":
                    command = new DoneCommand(commandDetails);
                break;
                case "delete":
                    command = new DeleteCommand(commandDetails);
                break;
                case "find":
                    command = new FindCommand(commandDetails);
                break;
            }
            break;
            case "list":
                command = new ListCommand();
            break;
            case "bye":
                command = new ExitCommand();
            break;
            default:
                throw new InvalidInputException();
        }
        return command;
    }
}

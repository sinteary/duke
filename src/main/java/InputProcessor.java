import java.util.Scanner;

public class InputProcessor {
    boolean hasDetails;
    String command;
    String details;

    public InputProcessor(String userInput) throws NoTaskDescriptionException, NoTaskNumberSpecifiedException, InvalidInputException {
        Scanner readUserInput = new Scanner(userInput);
        this.command = readUserInput.next();
        this.details = "";
        switch (this.command) {
            case "todo":
            case "event":
            case "deadline":
            case "done":
            case "delete":
                if (readUserInput.hasNext()) {
                    this.details = readUserInput.nextLine().trim();
                }
                else {
                    switch (this.command) {
                        case "delete":
                        case "done":
                            throw new NoTaskNumberSpecifiedException();
                        default:
                            throw new NoTaskDescriptionException(command);
                    }
                }
            case "list":
            case "bye":
                break;
            default:
                throw new InvalidInputException();
        }
    }

    String getCommand() {
        return this.command;
    }

    String getDetails() {
        return this.details;
    }

}

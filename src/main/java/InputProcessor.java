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
            case "find":
                if (readUserInput.hasNext()) {
                    this.details = readUserInput.nextLine().trim();
                }
                else {
                    switch (this.command) {
                        case "done":
                            throw new NoTaskNumberSpecifiedException();
                        case "finish":
                            //throw new NoKeywordSpecifiedException();
                        default:
                            throw new NoTaskDescriptionException(command);
                    }
                }
                break;
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

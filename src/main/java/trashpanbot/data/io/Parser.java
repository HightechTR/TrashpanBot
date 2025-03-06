package trashpanbot.data.io;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import trashpanbot.command.*;
import trashpanbot.common.*;
import trashpanbot.data.exception.InvalidSaveFormatException;
import trashpanbot.data.task.*;


public class Parser {

    public static final DateTimeFormatter DATE_INPUT_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Ui ui;

    public Parser(Ui ui) {
        this.ui = ui;
    }

    public Task parseFile(String[] inputParts) throws IOException {
        Task output;

        String[] parameter = inputParts[1].split(" \\| ", 2);

        // check if parameters in save file are valid
        if (parameter[0].isEmpty() || parameter[1].isEmpty()) {
            throw new InvalidSaveFormatException("Save file corrupted");
        }

        // add task based on task icon
        switch (inputParts[0]) {
        case "T" -> output = parseTodo(parameter, "", false);
        case "D" -> output = parseDeadline(parameter, "", false);
        case "E" -> output = parseEvent(parameter, "", false);
        default -> throw new InvalidSaveFormatException("Save file corrupted");
        }

        if (output == null) {
            throw new InvalidSaveFormatException("Save file corrupted");
        }

        // mark task done if status icon is X
        if (parameter[0].equals("X")) {
            output.setDone(true);
        }

        return output;
    }

    /**
     * Parses an integer value from input, returns the integer inputted
     * Displays message and returns null if no integer inputted or input is not an integer
     *
     * @param inputParts The input string array containing the integer
     * @return The integer inputted, null if not an integer or no integer inputted
     */
    public Integer parseInt(String[] inputParts, String usage) {
        try {
            return Integer.parseInt(Utils.checkEmpty(inputParts[1]));

        } catch (NumberFormatException e) { // check if number is valid
            ui.showMarkInvalidIndexError(usage);
            return null;

        } catch (IndexOutOfBoundsException e) { // check if parameter is non-empty
            ui.showMarkMissingIndexError(usage);
            return null;

        }
    }

    public String parseFind(String[] inputParts, String usage) {
        String description;

        try {
            description = Utils.checkEmpty(inputParts[1]);
        } catch (IndexOutOfBoundsException e) {
            ui.showParamMissingError(usage);
            return null;
        }

        return description;
    }

    /**
     * Adds a to-do to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     * @return To-do object with components defined
     */
    public Task parseTodo(String[] inputParts, String usage, boolean isNotSaveLoad)
            throws IOException {
        String description;

        // check if parameter is non-empty
        try {
            description = Utils.checkEmpty(inputParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                ui.showParamMissingError(usage);
                return null;
            } else {
                throw new IOException();
            }
        }

        return new Todo(description);
    }

    /**
     * Adds a deadline to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     * @return Deadline object with components defined
     */
    public Task parseDeadline(String[] inputParts, String usage, boolean isNotSaveLoad)
            throws IOException, DateTimeParseException {
        String[] parameterParts;
        String description;
        String deadline;

        // check if parameters are non-empty
        try {
            parameterParts = inputParts[1].split(" /by ", 2);
            description = Utils.checkEmpty(parameterParts[0]);
            deadline = Utils.checkEmpty(parameterParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                ui.showParamMissingError(usage);
                return null;
            } else {
                throw new IOException();
            }
        }

        return new Deadline(description, LocalDateTime.parse(deadline, DATE_INPUT_FORMAT));
    }

    /**
     * Adds an event to the list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     * @return Event object with components defined.
     */
    public Task parseEvent(String[] inputParts, String usage, boolean isNotSaveLoad)
            throws IOException, DateTimeParseException {
        String[] parameterParts;
        String description;
        String from;
        String to;

        try {
            parameterParts = inputParts[1].split(" /from | /to ", 3);
            description = Utils.checkEmpty(parameterParts[0]);
            from = Utils.checkEmpty(parameterParts[1]);
            to = Utils.checkEmpty(parameterParts[2]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                ui.showParamMissingError(usage);
                return null;
            } else {
                throw new IOException();
            }
        }

        return new Event(description, LocalDateTime.parse(from, DATE_INPUT_FORMAT),
                LocalDateTime.parse(to, DATE_INPUT_FORMAT));
    }

    /**
     * Creates a command object for the task list application based on the command inputted.
     *
     * @return The command object corresponding to the command inputted.
     */
    public Command parseCommand(String[] inputParts, Parser parser) {
        String command = inputParts[0];
        Command c;

        switch (command) {
        case "todo", "deadline", "event" -> c = new AddCommand(inputParts, parser);
        case "remove" -> c = new RemoveCommand(inputParts);
        case "list" -> c = new ListCommand(inputParts);
        case "find" -> c = new FindCommand(inputParts, parser);
        case "mark" -> c = new MarkCommand(inputParts, true);
        case "unmark" -> c = new MarkCommand(inputParts, false);
        case "help" -> c = new HelpCommand(inputParts);
        case "bye" -> c = new ExitCommand(inputParts);
        default -> c = new InvalidCommand(inputParts);
        }

        return c;
    }
}
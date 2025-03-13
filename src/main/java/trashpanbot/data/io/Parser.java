package trashpanbot.data.io;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import trashpanbot.command.*;
import trashpanbot.common.*;
import trashpanbot.data.exception.InvalidSaveFormatException;
import trashpanbot.data.task.*;

/**
 * Represents the parser functions.
 * Contains methods to handle parsing of input commands, parameters and save files.
 */
public class Parser {

    public static final DateTimeFormatter DATE_INPUT_FORMAT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
    private Ui ui;

    public Parser(Ui ui) {
        this.ui = ui;
    }

    /**
     * Parses a single line of file contents during a save load.
     * Takes in the content after the last bar "|" and parses it into a Task object.
     *
     * @param inputParts The String array containing the parts of each line in the save file.
     * @return A Task class corresponding to the task in the save file.
     * @throws IOException If the input format is invalid, i.e. the save file is corrupted
     */
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
     * Parses an integer value from input and returns the integer inputted.
     * Displays message and returns null if no integer is inputted
     * or the input is not an integer.
     *
     * @param inputParts The input string array containing the integer.
     * @param usage The usage text of the command that calls this method.
     * @return The integer inputted if the integer is valid, null if invalid or missing.
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

    /**
     * Parses the parameters for the find command.
     *
     * @param inputParts The input string array containing the keyword.
     * @param usage The usage text of the find command.
     * @return The keyword string.
     */
    public String parseFind(String[] inputParts, String usage) {
        String keyword;

        try {
            keyword = Utils.checkEmpty(inputParts[1]);
        } catch (IndexOutOfBoundsException e) {
            ui.showParamMissingError(usage);
            return null;
        }

        return keyword;
    }

    /**
     * Parses the parameters for the to-do command.
     *
     * @param inputParts The input string array containing the description.
     * @param usage The usage text of the to-do command.
     * @param isNotSaveLoad True if not called in a save load, false otherwise.
     * @return To-do object with the description parsed.
     * @throws IOException During save load if format is invalid.
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
     * Parses the parameters for the deadline command.
     *
     * @param inputParts The input string array containing the description and deadline.
     * @param usage The usage text of the deadline command.
     * @param isNotSaveLoad True if not called in a save load, false otherwise.
     * @return Deadline object with the description and deadline parsed.
     * @throws IOException During save load if format is invalid.
     * @throws DateTimeParseException If deadline is in an invalid format.
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
     * Parses the parameters for the event command.
     *
     * @param inputParts The input string array containing the description, start and end date.
     * @param usage The usage text of the event command.
     * @param isNotSaveLoad True if not called in a save load, false otherwise.
     * @return Event object with the description and dates parsed.
     * @throws IOException During save load if format is invalid.
     * @throws DateTimeParseException If either the start or end date is in an invalid format.
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

        // swap from and to if /to is written before /from in input
        if (inputParts[1].indexOf("/from") > inputParts[1].indexOf("/to")) {
            String temp = to;
            to = from;
            from = temp;
        }

        return new Event(description, LocalDateTime.parse(from, DATE_INPUT_FORMAT),
                LocalDateTime.parse(to, DATE_INPUT_FORMAT));
    }

    /**
     * Creates a command object for the task list application based on the command inputted.
     *
     * @param inputParts The String array containing the parameters for the command.
     * @param parser The Parser object.
     * @return The Command object corresponding to the input command.
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
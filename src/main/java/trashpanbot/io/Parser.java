package trashpanbot.io;

import java.io.IOException;

import trashpanbot.exception.InvalidSaveFormatException;
import trashpanbot.exception.StringArrayEmptyException;
import trashpanbot.task.*;


public class Parser {

    private static final Ui ui = new Ui();

    /**
     * Checks if a string is empty.
     *
     * @param input The input string to be checked.
     * @return The input string if it is non-empty.
     * @throws StringArrayEmptyException if string is empty.
     */
    public static String checkEmpty(String input) {
        if (input.isEmpty()) {
            throw new StringArrayEmptyException();
        }
        return input;
    }

    public static Task parseFile(String[] inputParts) throws IOException {
        Task output;

        String[] parameter = inputParts[1].split(" \\| ", 2);

        // check if parameters in save file are valid
        if (parameter[0].isEmpty() || parameter[1].isEmpty()) {
            throw new InvalidSaveFormatException();
        }

        // add task based on task icon
        switch (inputParts[0]) {
        case "T" -> output = parseTodo(parameter, false);
        case "D" -> output = parseDeadline(parameter, false);
        case "E" -> output = parseEvent(parameter, false);
        default -> throw new InvalidSaveFormatException();
        }

        if (output == null) {
            throw new InvalidSaveFormatException();
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
    public static Integer tryParseInt(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        try {
            return Integer.parseInt(checkEmpty(inputParts[1]));
        } catch (NumberFormatException e) { // check if number is valid
            if (isNotSaveLoad) {
                System.out.println(Text.TASK_MARK_NOT_NUM);
                return null;
            } else {
                throw new IOException();
            }
        } catch (IndexOutOfBoundsException e) { // check if parameter is non-empty
            if (isNotSaveLoad) {
                System.out.println(Text.TASK_MARK_NO_NUM);
                return null;
            } else {
                throw new IOException();
            }
        }
    }

    /**
     * Adds a to-do to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static Task parseTodo(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        String description;

        // check if parameter is non-empty
        try {
            description = checkEmpty(inputParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.TODO_MISSING);
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
     */
    public static Task parseDeadline(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        String[] parameterParts;
        String description;
        String deadline;

        // check if parameters are non-empty
        try {
            parameterParts = inputParts[1].split(" /by ", 2);
            description = checkEmpty(parameterParts[0]);
            deadline = checkEmpty(parameterParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.DEADLINE_MISSING);
                return null;
            } else {
                throw new IOException();
            }
        }

        return new Deadline(description, deadline);
    }

    /**
     * Adds an event to the list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static Task parseEvent(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        String[] parameterParts;
        String description;
        String from;
        String to;

        try {
            parameterParts = inputParts[1].split(" /from | /to ", 3);
            description = checkEmpty(parameterParts[0]);
            from = checkEmpty(parameterParts[1]);
            to = checkEmpty(parameterParts[2]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.EVENT_MISSING);
                return null;
            } else {
                throw new IOException();
            }
        }

        return new Event(description, from, to);
    }

    /**
     * Calls methods for the task list application based on the command inputted.
     */
    public static boolean parseCommand(TaskList tasks, String[] inputParts) throws IOException {
        String command;
        boolean isRunning = true;

        command = inputParts[0];

        switch (command) {
        case "todo" -> tasks.addTask(parseTodo(inputParts, true));
        case "deadline" -> tasks.addTask(parseDeadline(inputParts, true));
        case "event" -> tasks.addTask(parseEvent(inputParts, true));
        case "remove" -> tasks.removeTask(inputParts);
        case "list" -> tasks.displayList();
        case "mark" -> tasks.markTask(inputParts, true, true);
        case "unmark" -> tasks.markTask(inputParts, false, true);
        case "help" -> System.out.println(Text.TASK_LIST_COMMANDS);
        case "bye" -> isRunning = false;
        default -> System.out.println(Text.COMMAND_INVALID);
        }

        return isRunning;
    }
}
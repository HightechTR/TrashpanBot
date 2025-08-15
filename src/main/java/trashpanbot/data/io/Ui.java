package trashpanbot.data.io;

import java.util.ArrayList;
import java.util.Scanner;

import trashpanbot.command.*;
import trashpanbot.common.*;
import trashpanbot.data.task.*;

/**
 * Represents the UI functions.
 * Contains methods to read inputs and print to output.
 */
public class Ui {

    private static final Scanner in = new Scanner(System.in);
    public static final int INDEX_OFFSET = 1;

    /*
    =================================================================================
    Input UI
    =================================================================================
     */

    /**
     * Reads in an input and parses it into command and parameter.
     *
     * @return The string array containing the command and parameter
     */
    public String[] readInput() {
        showCommandInput();
        String userInput = in.nextLine();
        showLine();
        return userInput.split(" ", 2);
    }

    /*
    =================================================================================
    General Text UI
    =================================================================================
     */

    /**
     * Prints a list of tasks to the output.
     * Used by the list and find commands.
     *
     * @param tasks ArrayList of Task objects to print.
     * @param list ArrayList of indexes corresponding to the tasks to be printed.
     */
    public void displayList(ArrayList<Task> tasks, ArrayList<Integer> list) {
        if (tasks.isEmpty()) {
            return;
        }
        for (Integer i : list) {
            printTask(tasks, i);
        }
    }

    /**
     * Displays the text for the list command.
     */
    public void showFullList() {
        System.out.println(Text.TASK_LIST_DISPLAY);
    }

    /**
     * Displays the text for an empty list when the list command is run.
     */
    public void showListEmpty() {
        System.out.println(Text.TASK_LIST_EMPTY);
    }

    /**
     * Displays the text for the find command.
     */
    public void showSearchResult() {
        System.out.println(Text.TASK_FIND_LIST_DISPLAY);
    }

    /**
     * Displays the text for an empty list when the find command is run.
     */
    public void showSearchEmpty() {
        System.out.println(Text.TASK_FIND_LIST_EMPTY);
    }

    /**
     * Prints a single task with its type, description and dates (if any).
     *
     * @param tasks ArrayList of Task objects to print.
     * @param i Index corresponding to the task to be printed.
     */
    public void printTask(ArrayList<Task> tasks, int i) {
        System.out.print((i + INDEX_OFFSET) + ".[" + tasks.get(i).getTypeIcon() + "]");
        System.out.print("[" + tasks.get(i).getStatusIcon() + "] ");
        System.out.println(tasks.get(i).getDescription()
                + tasks.get(i).getDate());
    }

    /**
     * Prints the most recent task after adding.
     *
     * @param tasks ArrayList of Task objects to print.
     */
    public void printAddedText(ArrayList<Task> tasks) {
        System.out.println(Text.TASK_ADDED);
        printTask(tasks, tasks.size() - 1);
        System.out.print("You have " + tasks.size() + " ");
        System.out.println(tasks.size() == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Prints task to be removed.
     *
     * @param tasks ArrayList of Task objects to print.
     * @param index Index corresponding to the task to be removed.
     */
    public void printRemovedText(ArrayList<Task> tasks, int index) {
        System.out.println(Text.TASK_REMOVED);
        printTask(tasks, index);
        System.out.print("You have " + (tasks.size() - 1) + " ");
        System.out.println(tasks.size() - 1 == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Displays the text for marking a task as done.
     */
    public void showTaskDone() {
        System.out.println(Text.TASK_MARK_DONE);
    }

    /**
     * Displays the text for marking a task as not done.
     */
    public void showTaskUndone() {
        System.out.println(Text.TASK_MARK_UNDONE);
    }

    /**
     * Displays the text for setting the time format.
     *
     * @param is24Hour True if the format is set to 24 Hour, false if 12 Hour.
     */
    public void showHourSet(boolean is24Hour) {
        System.out.println(Text.HOUR_SET +
                (is24Hour ? "24 Hour" : "12 Hour") + ".");
    }

    /*
    =================================================================================
    Input Error Text UI
    =================================================================================
     */

    /**
     * Displays the error text when inputting an index that exceeds the TaskList size.
     * Used for the mark, unmark and remove commands.
     */
    public void showOutOfBoundsError() {
        System.out.println(Text.TASK_OOB);
    }

    /**
     * Displays error text when the index parameter is missing.
     * Used for the mark, unmark and remove commands.
     *
     * @param usage The usage text of the command calling this method.
     */
    public void showMarkMissingIndexError(String usage) {
        System.out.println(Text.TASK_PARAMETER_MISSING + System.lineSeparator() + usage);
    }

    /**
     * Displays error text when the index parameter is not a valid integer.
     * Used for the mark, unmark and remove commands.
     *
     * @param usage The usage text of the command calling this method.
     */
    public void showMarkInvalidIndexError(String usage) {
        System.out.println(Text.TASK_MARK_INVALID_NUM + System.lineSeparator() + usage);
    }

    /**
     * Displays error text when a parameter is missing.
     * Used for the to-do, deadline, event and find commands.
     *
     * @param usage The usage text of the command calling this method.
     */
    public void showParamMissingError(String usage) {
        System.out.println(Text.TASK_PARAMETER_MISSING + System.lineSeparator() + usage);
    }

    /**
     * Displays error text when a date is in an invalid format.
     * Used for the deadline and event commands.
     *
     * @param usage The usage text of the command calling this method.
     */
    public void showDateFormatError(String usage) {
        System.out.println(Text.TASK_DATE_FORMAT_ERROR + System.lineSeparator() + usage);
    }

    /**
     * Displays error text when a boolean is invalid.
     * Used for the 24hour command.
     *
     * @param usage The usage text of the command calling this method.
     */
    public void showInvalidBooleanError (String usage) {
        System.out.println(Text.INVALID_BOOLEAN_ERROR + System.lineSeparator() + usage);
    }

    /*
    =================================================================================
    Command-related Text UI
    =================================================================================
     */

    /**
     * Displays the user interface text for a command input.
     */
    public void showCommandInput() {
        System.out.println(Text.LINE);
        System.out.print("> ");
    }

    /**
     * Prints the full list of commands and their usages to the output.
     */
    public void displayCommands() {
        System.out.println("List of Commands" + System.lineSeparator()
                + AddCommand.TODO_USAGE + System.lineSeparator()
                + AddCommand.DEADLINE_USAGE + System.lineSeparator()
                + AddCommand.EVENT_USAGE + System.lineSeparator()
                + ListCommand.COMMAND_USAGE + System.lineSeparator()
                + FindCommand.COMMAND_USAGE + System.lineSeparator()
                + MarkCommand.MARK_USAGE + System.lineSeparator()
                + MarkCommand.UNMARK_USAGE + System.lineSeparator()
                + RemoveCommand.COMMAND_USAGE + System.lineSeparator()
                + HourCommand.COMMAND_USAGE + System.lineSeparator()
                + HelpCommand.COMMAND_USAGE + System.lineSeparator()
                + ExitCommand.COMMAND_USAGE);
    }

    /**
     * Displays the error message when a command entered is invalid.
     */
    public void showInvalidCommandError() {
        System.out.println(Text.COMMAND_INVALID);
    }

    /*
    =================================================================================
    File-related Text UI
    =================================================================================
     */

    /**
     * Displays the text when a save file is found and is being read.
     */
    public void showFileReading() {
        System.out.println(Text.FILE_READING);
    }

    /**
     * Displays the text when a save file is corrupted.
     */
    public void showFileCorrupted() {
        System.out.println(Text.FILE_READ_ERROR);
    }

    /**
     * Displays the text when the save file is missing and a new file is created.
     */
    public void showFileCreation() {
        System.out.println(Text.FILE_CREATE);
    }

    /**
     * Displays text when an unknown IOException is thrown in the file creation process.
     */
    public void showFileUnknownError() {
        System.out.println(Text.FILE_CREATE_ERROR);
    }

    /**
     * Displays text when an unknown IOException is thrown while writing to the file.
     */
    public void showFileWriteError() {
        System.out.println(Text.FILE_WRITE_ERROR);
    }

    /*
    =================================================================================
    General Usage Text UI
    =================================================================================
     */

    /**
     * Displays the introduction text.
     */
    public void showIntro() {
        System.out.println(Text.INTRO);
        System.out.println(Text.TASK_LIST_DESCRIPTION);
    }

    /**
     * Prints a separator line.
     */
    public void showLine() {
        System.out.println(Text.LINE);
    }
}
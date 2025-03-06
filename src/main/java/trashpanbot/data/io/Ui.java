package trashpanbot.data.io;

import java.util.ArrayList;
import java.util.Scanner;

import trashpanbot.command.AddCommand;
import trashpanbot.command.ExitCommand;
import trashpanbot.command.HelpCommand;
import trashpanbot.command.ListCommand;
import trashpanbot.command.MarkCommand;
import trashpanbot.command.RemoveCommand;
import trashpanbot.common.*;
import trashpanbot.data.task.*;

public class Ui {

    private static final Scanner in = new Scanner(System.in);

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
    General Task-related Text UI
    =================================================================================
     */

    /**
     * Displays task list to the output.
     */
    public void displayList(ArrayList<Task> tasks, ArrayList<Integer> list) {
        if (tasks.isEmpty()) {
            return;
        }
        for (Integer i : list) {
            printTask(tasks, i);
        }
    }

    public void showFullList() {
        System.out.println(Text.TASK_LIST_DISPLAY);
    }

    public void showListEmpty() {
        System.out.println(Text.TASK_LIST_EMPTY);
    }

    public void showSearchResult() {
        System.out.println(Text.FIND_LIST_DISPLAY);
    }

    public void showSearchEmpty() {
        System.out.println(Text.SEARCH_LIST_EMPTY);
    }

    /**
     * Prints a task with its type and dates (if any).
     *
     * @param i The index of the task to be printed.
     */
    public void printTask(ArrayList<Task> tasks, int i) {
        System.out.print(i + ".[" + tasks.get(i - 1).getTypeIcon() + "]");
        System.out.print("[" + tasks.get(i - 1).getStatusIcon() + "] ");
        System.out.println(tasks.get(i - 1).getDescription()
                + tasks.get(i - 1).getDate());
    }

    /**
     * Prints most recent task after adding.
     */
    public void printAddedText(ArrayList<Task> tasks) {
        System.out.println(Text.TASK_ADDED);
        printTask(tasks, tasks.size());
        System.out.print("You have " + tasks.size() + " ");
        System.out.println(tasks.size() == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Prints most recent task after adding.
     */
    public void printRemovedText(ArrayList<Task> tasks, int index) {
        System.out.println(Text.TASK_REMOVED);
        printTask(tasks, index);
        System.out.print("You have " + (tasks.size() - 1) + " ");
        System.out.println(tasks.size() - 1 == 1 ? "task now!" : "tasks now!");
    }

    public void showTaskDone() {
        System.out.println(Text.TASK_MARK_DONE);
    }

    public void showTaskUndone() {
        System.out.println(Text.TASK_MARK_UNDONE);
    }

    /*
    =================================================================================
    Task Input Error Text UI
    =================================================================================
     */

    public void showOutOfBoundsError() {
        System.out.println(Text.TASK_OOB);
    }

    public void showMarkMissingIndexError(String usage) {
        System.out.println(Text.TASK_PARAMETER_MISSING + System.lineSeparator() + usage);
    }

    public void showMarkInvalidIndexError(String usage) {
        System.out.println(Text.TASK_MARK_INVALID_NUM + System.lineSeparator() + usage);
    }

    public void showParamMissingError(String usage) {
        System.out.println(Text.TASK_PARAMETER_MISSING + System.lineSeparator() + usage);
    }

    public void showDateFormatError(String usage) {
        System.out.println(Text.TASK_DATE_FORMAT_ERROR + System.lineSeparator() + usage);
    }

    /*
    =================================================================================
    Command-related Text UI
    =================================================================================
     */

    public void showCommandInput() {
        System.out.println(Text.LINE);
        System.out.print("> ");
    }

    public void displayCommands() {
        System.out.println("List of Commands" + System.lineSeparator()
                + AddCommand.TODO_USAGE + System.lineSeparator()
                + AddCommand.DEADLINE_USAGE + System.lineSeparator()
                + AddCommand.EVENT_USAGE + System.lineSeparator()
                + ListCommand.COMMAND_USAGE + System.lineSeparator()
                + RemoveCommand.COMMAND_USAGE + System.lineSeparator()
                + MarkCommand.MARK_USAGE + System.lineSeparator()
                + MarkCommand.UNMARK_USAGE + System.lineSeparator()
                + HelpCommand.COMMAND_USAGE + System.lineSeparator()
                + ExitCommand.COMMAND_USAGE);
    }

    public void showInvalidCommandError() {
        System.out.println(Text.COMMAND_INVALID);
    }

    /*
    =================================================================================
    File-related Text UI
    =================================================================================
     */

    public void showFileReading() {
        System.out.println(Text.FILE_READING);
    }

    public void showFileCorrupted() {
        System.out.println(Text.FILE_READ_ERROR);
    }

    public void showFileCreation() {
        System.out.println(Text.FILE_CREATE);
    }

    public void showFileUnknownError() {
        System.out.println(Text.FILE_UNKNOWN_ERROR);
    }

    public void showFileWriteError() {
        System.out.println(Text.FILE_WRITE_ERROR);
    }

    /*
    =================================================================================
    General Usage Text UI
    =================================================================================
     */

    public void showIntro() {
        System.out.println(Text.INTRO);
        System.out.println(Text.TASK_LIST);
    }

    public void showLine() {
        System.out.println(Text.LINE);
    }
}
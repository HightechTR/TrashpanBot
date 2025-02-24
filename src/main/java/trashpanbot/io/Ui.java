package trashpanbot.io;

import java.util.ArrayList;
import java.util.Scanner;

import trashpanbot.task.*;

public class Ui {

    private static final Scanner in = new Scanner(System.in);

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

    public void showIntro() {
        System.out.println(Text.INTRO);
        System.out.println(Text.TASK_LIST);
    }

    public void showCommandInput() {
        System.out.println(Text.LINE);
        System.out.print("> ");
    }

    public void displayCommands() {
        System.out.println(Text.TASK_LIST_COMMANDS);
    }

    public void showFileReading() {
        System.out.println(Text.FILE_READING);
    }

    public void showFileCorrupted() {
        System.out.println(Text.FILE_READ_ERROR);
    }

    public void showFileCreation() {
        System.out.println(Text.FILE_CREATE);
    }

    public void showFileDirectoryError() {
        System.out.println(Text.FILE_DIRECTORY_MISSING);
    }

    public void showFileWriteError() {
        System.out.println(Text.FILE_WRITE_ERROR);
    }

    public void showLine() {
        System.out.println(Text.LINE);
    }
}
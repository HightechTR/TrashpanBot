package trashpanbot.task;

import java.io.IOException;

import trashpanbot.*;
import trashpanbot.exception.*;
import trashpanbot.save.Save;

public abstract class Task {
    private final String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public String getDeadline() {
        return "";
    };

    public String getFrom() {
        return "";
    }

    public String getTo() {
        return "";
    }

    public abstract String getTypeIcon();

    public abstract String getDate();

    public void setDone(boolean done) {
        this.isDone = done;
    }

    /**
     * Checks if the list is full (100 tasks).
     *
     * @return True if the list is full.
     */
    public static boolean isListFull() {
        if (TrashpanMain.listCounter > 99) {
            System.out.println(Text.TASK_LIST_FULL);
        }
        return TrashpanMain.listCounter > 99;
    }

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

    /**
     * Prints a task with its type and dates (if any).
     *
     * @param i The index of the task to be printed.
     */
    private static void printTask(int i) {
        System.out.print(i + ".[" + TrashpanMain.tasks[i - 1].getTypeIcon() + "]");
        System.out.print("[" + TrashpanMain.tasks[i - 1].getStatusIcon() + "] ");
        System.out.println(TrashpanMain.tasks[i - 1].getDescription() + TrashpanMain.tasks[i - 1].getDate());
    }

    /**
     * Displays task list to the output.
     */
    public static void displayList() {
        if (TrashpanMain.listCounter == 0) {
            System.out.println(Text.TASK_LIST_EMPTY);
            return;
        }
        System.out.println(Text.TASK_LIST_DISPLAY);
        for (int i = 1; i <= TrashpanMain.listCounter; i++) {
            printTask(i);
        }
    }

    /**
     * Prints most recent task after adding.
     */
    static void printAddedText() {
        System.out.println(Text.TASK_ADDED);
        printTask(TrashpanMain.listCounter);
        System.out.print("You have " + TrashpanMain.listCounter + " ");
        System.out.println(TrashpanMain.listCounter == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Marks a task as done or not done in the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone     Boolean to set the task as done or not done.
     */
    public static void markTask(String[] inputParts,
                                boolean isDone, boolean isNotSaveLoad) throws IOException {
        int index;

        try {
            index = Integer.parseInt(checkEmpty(inputParts[1]));
        } catch (NumberFormatException e) { // check if number is valid
            if (isNotSaveLoad) {
                System.out.println(Text.TASK_MARK_NOT_NUM);
            } else {
                throw new IOException();
            }
            return;
        } catch (IndexOutOfBoundsException e) { // check if parameter is non-empty
            if (isNotSaveLoad) {
                System.out.println(Text.TASK_MARK_NO_NUM);
            } else {
                throw new IOException();
            }
            return;
        }

        // check if number is in bounds
        if (index > TrashpanMain.listCounter) {
            System.out.println(Text.TASK_MARK_OOB);
        } else {
            TrashpanMain.tasks[index - 1].setDone(isDone);
            if (isNotSaveLoad) {
                System.out.println(isDone ? Text.TASK_MARK_DONE : Text.TASK_MARK_UNDONE);
                printTask(index);
                Save.updateFile(TrashpanMain.filePath);
            }
        }
    }
}

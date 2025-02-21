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
        System.out.print(i + ".[" + TrashpanMain.tasks.get(i - 1).getTypeIcon() + "]");
        System.out.print("[" + TrashpanMain.tasks.get(i - 1).getStatusIcon() + "] ");
        System.out.println(TrashpanMain.tasks.get(i - 1).getDescription()
                + TrashpanMain.tasks.get(i - 1).getDate());
    }

    /**
     * Displays task list to the output.
     */
    public static void displayList() {
        if (TrashpanMain.tasks.isEmpty()) {
            System.out.println(Text.TASK_LIST_EMPTY);
            return;
        }
        System.out.println(Text.TASK_LIST_DISPLAY);
        for (int i = 1; i <= TrashpanMain.tasks.size(); i++) {
            printTask(i);
        }
    }

    /**
     * Prints most recent task after adding.
     */
    static void printAddedText() {
        System.out.println(Text.TASK_ADDED);
        printTask(TrashpanMain.tasks.size());
        System.out.print("You have " + TrashpanMain.tasks.size() + " ");
        System.out.println(TrashpanMain.tasks.size() == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Prints most recent task after adding.
     */
    static void printRemovedText(int index) {
        System.out.println(Text.TASK_REMOVED);
        printTask(index);
        System.out.print("You have " + (TrashpanMain.tasks.size() - 1) + " ");
        System.out.println(TrashpanMain.tasks.size() - 1 == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Parses an integer value from input, returns the integer inputted
     * Displays message and returns null if no integer inputted or input is not an integer
     *
     * @param inputParts The input string array containing the integer
     * @return The integer inputted, null if not an integer or no integer inputted
     */
    static Integer tryParseInt(String[] inputParts, boolean isNotSaveLoad) throws IOException {
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

    public static void removeTask(String[] inputParts) throws IOException {
        Integer index = tryParseInt(inputParts, true);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if number is in bounds
        if (index > TrashpanMain.tasks.size()) {
            System.out.println(Text.TASK_MARK_OOB);
        } else {
            printRemovedText(index);
            TrashpanMain.tasks.remove(index - 1);
        }
    }

    /**
     * Marks a task as done or not done in the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone     Boolean to set the task as done or not done.
     */
    public static void markTask(String[] inputParts, boolean isDone, boolean isNotSaveLoad) throws IOException {
        Integer index = tryParseInt(inputParts, isNotSaveLoad);

        // check if index is valid
        if (index == null) {
            if (isNotSaveLoad) {
                return;
            } else {
                throw new IOException();
            }
        }

        // check if number is in bounds
        if (index > TrashpanMain.tasks.size()) {
            System.out.println(Text.TASK_MARK_OOB);
        } else {
            TrashpanMain.tasks.get(index - 1).setDone(isDone);
            if (isNotSaveLoad) {
                System.out.println(isDone ? Text.TASK_MARK_DONE : Text.TASK_MARK_UNDONE);
                printTask(index);
                Save.updateFile(TrashpanMain.filePath);
            }
        }
    }
}

package trashpanbot.data.task;

import java.util.ArrayList;

import trashpanbot.command.MarkCommand;
import trashpanbot.command.RemoveCommand;
import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;

/**
 * Represents the entire Task List.
 * Contains the ArrayList of Task objects, and methods to handle
 * adding, removing and marking tasks.
 */
public class TaskList {

    private ArrayList<Task> tasks;
    private Ui ui;
    private Parser parser;

    public static final int INDEX_OFFSET = 1;

    public TaskList(Parser parser, Ui ui) {
        this.parser = parser;
        this.ui = ui;
        this.tasks = new ArrayList<>();
    }

    public TaskList(Parser parser, Ui ui, ArrayList<Task> tasks) {
        this.parser = parser;
        this.ui = ui;
        this.tasks = tasks;
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    /**
     * Adds a task to the list, then saves the list.
     *
     * @param task The Task object to be added to the list.
     * @param save The Save object.
     */
    public void addTask(Task task, Save save) {
        if (task == null) {
            return;
        }

        tasks.add(task);

        ui.printAddedText(tasks);
        save.updateFile(tasks);
    }

    /**
     * Removes a task from the list, then saves the list.
     *
     * @param inputParts The input string array containing the task index to be removed.
     * @param save The Save object.
     */
    public void removeTask(String[] inputParts, Save save) {
        Integer index = parser.parseInt(inputParts, RemoveCommand.COMMAND_USAGE);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if index is in the list
        if (index > tasks.size()) {
            ui.showOutOfBoundsError();
        } else {
            ui.printRemovedText(tasks, index - INDEX_OFFSET);
            tasks.remove(index - INDEX_OFFSET);
            save.updateFile(tasks);
        }
    }

    /**
     * Marks a task as done or not done in the list, then saves the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone     Boolean to set the task as done or not done.
     */
    public void markTask(String[] inputParts, Save save, boolean isDone) {
        Integer index = parser.parseInt(inputParts,
                isDone ? MarkCommand.MARK_USAGE : MarkCommand.UNMARK_USAGE);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if number is in bounds
        if (index > tasks.size()) {
            ui.showOutOfBoundsError();
        } else {
            tasks.get(index - INDEX_OFFSET).setDone(isDone);

            if (isDone) {
                ui.showTaskDone();
            } else {
                ui.showTaskUndone();
            }

            ui.printTask(tasks, index - INDEX_OFFSET);
            save.updateFile(tasks);
        }
    }
}

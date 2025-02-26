package trashpanbot.data.task;

import java.util.ArrayList;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;

public class TaskList {

    private ArrayList<Task> tasks;
    private Ui ui;
    private Parser parser;

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

    public void addTask(Task task, Save save) {
        if (task == null) {
            return;
        }

        tasks.add(task);

        ui.printAddedText(tasks);
        save.updateFile(tasks);
    }

    public void removeTask(String[] inputParts, Save save) {
        Integer index = parser.parseInt(inputParts);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if number is in bounds
        if (index > tasks.size()) {
            ui.showOutOfBoundsError();
        } else {
            ui.printRemovedText(tasks, index);
            tasks.remove(index - 1);
            save.updateFile(tasks);
        }
    }

    /**
     * Marks a task as done or not done in the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone     Boolean to set the task as done or not done.
     */
    public void markTask(String[] inputParts, Save save, boolean isDone) {
        Integer index = parser.parseInt(inputParts);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if number is in bounds
        if (index > tasks.size()) {
            ui.showOutOfBoundsError();
        } else {
            tasks.get(index - 1).setDone(isDone);

            if (isDone) {
                ui.showTaskDone();
            } else {
                ui.showTaskUndone();
            }

            ui.printTask(tasks, index);
            save.updateFile(tasks);
        }
    }
}

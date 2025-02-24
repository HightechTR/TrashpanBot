package trashpanbot.task;

import java.io.IOException;
import java.util.ArrayList;

import trashpanbot.TrashpanBot;
import trashpanbot.io.*;
import trashpanbot.save.Save;

public class TaskList {

    private final Ui ui = new Ui();
    private final Save save = new Save();
    private final ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Displays task list to the output.
     */
    public void displayList() {
        if (tasks.isEmpty()) {
            System.out.println(Text.TASK_LIST_EMPTY);
            return;
        }
        System.out.println(Text.TASK_LIST_DISPLAY);
        for (int i = 1; i <= tasks.size(); i++) {
            ui.printTask(tasks, i);
        }
    }

    public void addTask(Task task) {
        if (task == null) {
            return;
        }
        tasks.add(task);

        ui.printAddedText(tasks);
        save.updateFile(tasks, TrashpanBot.filePath);
    }

    public void removeTask(String[] inputParts) throws IOException {
        Integer index = Parser.tryParseInt(inputParts, true);

        // check if index is valid
        if (index == null) {
            return;
        }

        // check if number is in bounds
        if (index > tasks.size()) {
            System.out.println(Text.TASK_MARK_OOB);
        } else {
            ui.printRemovedText(tasks, index);
            tasks.remove(index - 1);
            save.updateFile(tasks, TrashpanBot.filePath);
        }
    }

    /**
     * Marks a task as done or not done in the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone     Boolean to set the task as done or not done.
     */
    public void markTask(String[] inputParts, boolean isDone, boolean isNotSaveLoad) throws IOException {
        Integer index = Parser.tryParseInt(inputParts, isNotSaveLoad);

        // check if index is valid
        if (index == null) {
            if (isNotSaveLoad) {
                return;
            } else {
                throw new IOException();
            }
        }

        // check if number is in bounds
        if (index > tasks.size()) {
            System.out.println(Text.TASK_MARK_OOB);
        } else {
            tasks.get(index - 1).setDone(isDone);
            if (isNotSaveLoad) {
                System.out.println(isDone ? Text.TASK_MARK_DONE : Text.TASK_MARK_UNDONE);
                ui.printTask(tasks, index);
                save.updateFile(tasks, TrashpanBot.filePath);
            }
        }
    }
}

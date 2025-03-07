package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

/**
 * Parent abstract class for all <code>Command</code> objects.
 */
public abstract class Command {
    String[] inputParts;

    public Command(String[] inputParts) {
        this.inputParts = inputParts;
    }

    /**
     * Executes the functions of the related command.
     *
     * @param tasks The TaskList object containing the task list.
     * @param ui The Ui object handling UI functions.
     * @param save The Save object handling save functions.
     */
    public abstract void execute(TaskList tasks, Ui ui, Save save);

    /**
     * Sets the exit flag for exiting the program.
     *
     * @return True if called by ExitCommand, false otherwise.
     */
    public abstract boolean isExit();
}

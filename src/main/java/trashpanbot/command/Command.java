package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

public abstract class Command {
    String[] inputParts;

    public Command(String[] inputParts) {
        this.inputParts = inputParts;
    }

    public abstract void execute(TaskList tasks, Ui ui, Save save);

    public abstract boolean isExit();
}

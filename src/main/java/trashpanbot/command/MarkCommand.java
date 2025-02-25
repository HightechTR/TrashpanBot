package trashpanbot.command;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class MarkCommand extends Command {
    private final boolean isDone;

    public MarkCommand(String[] inputParts, boolean isDone) {
        super(inputParts);
        this.isDone = isDone;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        tasks.markTask(inputParts, save, isDone);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

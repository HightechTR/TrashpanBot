package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

public class InvalidCommand extends Command {
    public InvalidCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        ui.showInvalidCommandError();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

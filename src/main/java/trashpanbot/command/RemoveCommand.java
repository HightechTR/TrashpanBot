package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

public class RemoveCommand extends Command {
    public RemoveCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        tasks.removeTask(inputParts, save);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

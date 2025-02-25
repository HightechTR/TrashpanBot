package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

public class ExitCommand extends Command{

    public ExitCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {

    }

    @Override
    public boolean isExit() {
        return true;
    }
}

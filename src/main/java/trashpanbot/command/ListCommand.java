package trashpanbot.command;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class ListCommand extends Command {
    public ListCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        ui.displayList(tasks.getTasks());
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

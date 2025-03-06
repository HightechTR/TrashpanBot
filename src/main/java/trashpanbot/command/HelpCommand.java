package trashpanbot.command;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

public class HelpCommand extends Command {
    public static final String COMMAND_USAGE = """
            "help": Displays this command list
                e.g. help""";

    public HelpCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        ui.displayCommands();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

package trashpanbot.command;

import trashpanbot.data.io.Ui;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.TaskList;

/**
 * Represents the remove command.
 */
public class RemoveCommand extends Command {
    public static final String COMMAND_USAGE = """
            "remove <number>": Removes the task labelled with the number
                <number> - The index of the task in the last shown list
                e.g. remove 1""";

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

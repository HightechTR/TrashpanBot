package trashpanbot.command;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class MarkCommand extends Command {
    private final boolean isDone;

    public static final String MARK_USAGE = """
            "mark <number>": Marks the task labelled with the number as done
                <number> - The index of the task in the last shown list
                e.g. mark 1""";

    public static final String UNMARK_USAGE = """
            "unmark <number>": Marks the task labelled with the number as not done
                <number> - The index of the task in the last shown list
                e.g. unmark 1""";

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

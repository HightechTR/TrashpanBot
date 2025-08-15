package trashpanbot.command;

import trashpanbot.data.io.*;
import trashpanbot.data.save.*;
import trashpanbot.data.task.*;

/**
 * Represents the 24hour command.
 */
public class HourCommand extends Command {
    private Parser parser;

    public static final String COMMAND_USAGE = """
            "24hour <true/false>": Sets the time display to be the 12 or 24 hour format
                true - 24 hour format, false - 12 hour format""";

    public HourCommand(String[] inputParts, Parser parser) {
        super(inputParts);
        this.parser = parser;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        parser.parseTimeFormat(inputParts, COMMAND_USAGE);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

package trashpanbot.command;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class AddCommand extends Command {
    private Task task;
    private Parser parser;

    public static final String TODO_USAGE = """
            "todo <description>": Adds a to-do task to the list
                <description> - The description of the task to be added
                e.g. todo Play Muse Dash""";

    public static final String DEADLINE_USAGE = """
            "deadline <description> /by <due>": Adds a deadline task to the list
                <description> - The description of the task to be added
                <due> - The due date & time, in format yyyy-mm-dd hh:mm
                e.g. deadline Finish Cover Song /by 2025-09-12 18:30""";

    public static final String EVENT_USAGE = """
            "event <description> /from <start> /to <end>": Adds a event task to the list
                <description> - The description of the task to be added
                <start> - The start date of the event, in format yyyy-mm-dd hh:mm
                <end> - The end date of the event, in format yyyy-mm-dd hh:mm
                e.g. event Raki Birthday!! /from 2025-10-24 12:00 /to 2025-10-24 18:00""";

    public AddCommand(String[] inputParts, Parser parser) {
        super(inputParts);
        this.parser = parser;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        try {
            switch (inputParts[0]) {
            case "todo" -> task = parser.parseTodo(inputParts, TODO_USAGE, true);
            case "deadline" -> task = parser.parseDeadline(inputParts, DEADLINE_USAGE, true);
            case "event" -> task = parser.parseEvent(inputParts, EVENT_USAGE, true);
            }
        } catch (DateTimeParseException e) {
            if (inputParts[0].equals("deadline")) {
                ui.showDateFormatError(DEADLINE_USAGE);
            } else if (inputParts[0].equals("event")) {
                ui.showDateFormatError(EVENT_USAGE);
            }
        } catch (IOException ignored) {
            // IOException should only be thrown during save load
        }
        tasks.addTask(task, save);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

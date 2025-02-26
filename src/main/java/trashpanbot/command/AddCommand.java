package trashpanbot.command;

import java.io.IOException;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class AddCommand extends Command {
    private Task task;
    private Parser parser;

    public AddCommand(String[] inputParts, Parser parser) {
        super(inputParts);
        this.parser = parser;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        try {
            switch (inputParts[0]) {
            case "todo" -> task = parser.parseTodo(inputParts, true);
            case "deadline" -> task = parser.parseDeadline(inputParts, true);
            case "event" -> task = parser.parseEvent(inputParts, true);
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

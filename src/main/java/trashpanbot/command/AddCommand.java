package trashpanbot.command;

import java.io.IOException;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class AddCommand extends Command {
    Task task;

    public AddCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        try {
            switch (inputParts[0]) {
            case "todo" -> task = Parser.parseTodo(inputParts, true);
            case "deadline" -> task = Parser.parseDeadline(inputParts, true);
            case "event" -> task = Parser.parseEvent(inputParts, true);
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

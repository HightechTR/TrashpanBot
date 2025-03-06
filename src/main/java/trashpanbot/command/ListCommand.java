package trashpanbot.command;

import java.util.ArrayList;

import trashpanbot.data.io.*;
import trashpanbot.data.save.Save;
import trashpanbot.data.task.*;

public class ListCommand extends Command {
    public static final String COMMAND_USAGE = """
            "list": Displays full list of tasks
                e.g. list""";

    public ListCommand(String[] inputParts) {
        super(inputParts);
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        ArrayList<Task> taskList = tasks.getTasks();
        ArrayList<Integer> indexList = new ArrayList<>();
        for (int i = 1; i <= taskList.size(); i++) {
            indexList.add(i);
        }

        ui.showFullList();
        ui.displayList(taskList, indexList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

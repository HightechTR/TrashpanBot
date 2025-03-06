package trashpanbot.command;

import java.util.ArrayList;

import trashpanbot.data.io.*;
import trashpanbot.data.save.*;
import trashpanbot.data.task.*;

public class FindCommand extends Command {
    private Parser parser;

    public static final String COMMAND_USAGE = """
            "find <keyword>": Searches for tasks with the keyword and prints them out
                <keyword> - The keyword to be searched
                e.g. find book""";

    public FindCommand(String[] inputParts, Parser parser) {
        super(inputParts);
        this.parser = parser;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Save save) {
        String keyword = parser.parseFind(inputParts, COMMAND_USAGE);
        if (keyword == null) {
            return;
        }

        ArrayList<Task> originalList = tasks.getTasks();
        ArrayList<Integer> searchResult = new ArrayList<>();

        for (int i = 0; i < originalList.size(); i++) {
            String description = originalList.get(i).getDescription();
            if (description.contains(keyword)) {
                searchResult.add(i + 1);
            }
        }

        if (searchResult.isEmpty()) {
            ui.showSearchEmpty();
        } else {
            ui.showSearchResult();
            ui.displayList(originalList, searchResult);
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}

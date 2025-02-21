package trashpanbot.task;

import java.io.IOException;

import trashpanbot.*;
import trashpanbot.save.Save;

public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }

    public String getDate() {
        return "";
    }

    /**
     * Adds a to-do to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static void addTodo(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        String description;

        // check if parameter is non-empty
        try {
            description = checkEmpty(inputParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.TODO_MISSING);
                return;
            } else {
                throw new IOException();
            }
        }

        TrashpanMain.tasks.add(new Todo(description));

        if (isNotSaveLoad) {
            printAddedText();
            Save.updateFile(TrashpanMain.filePath);
        }
    }
}
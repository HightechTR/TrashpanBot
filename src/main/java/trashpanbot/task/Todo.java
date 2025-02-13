package trashpanbot.task;

import trashpanbot.*;

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
    public static void addTodo(String[] inputParts) {
        // check if list is full
        if (isListFull()) {
            return;
        }

        // check if parameter is non-empty
        if (inputParts.length != 2 || inputParts[1].isEmpty()) {
            System.out.println(Text.TODO_NO_DESC);
            return;
        }

        String description = inputParts[1];
        TrashpanMain.tasks[TrashpanMain.listCounter] = new Todo(description);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
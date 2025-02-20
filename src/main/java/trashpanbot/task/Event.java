package trashpanbot.task;

import java.io.IOException;

import trashpanbot.*;
import trashpanbot.save.Save;

public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getFrom() {
        return from;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDate() {
        return " (from: " + from + " to: " + to + ")";
    }

    /**
     * Adds an event to the list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static void addEvent(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        // check if list is full
        if (isListFull()) {
            return;
        }

        String[] parameterParts;
        String description;
        String from;
        String to;

        try {
            parameterParts = inputParts[1].split(" /from | /to ", 3);
            description = checkEmpty(parameterParts[0]);
            from = checkEmpty(parameterParts[1]);
            to = checkEmpty(parameterParts[2]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.EVENT_MISSING);
            } else {
                throw new IOException();
            }
            return;
        }

        TrashpanMain.tasks[TrashpanMain.listCounter] = new Event(description, from, to);
        TrashpanMain.listCounter++;

        if (isNotSaveLoad) {
            printAddedText();
            Save.updateFile(TrashpanMain.filePath);
        }
    }
}
package trashpanbot.task;

import trashpanbot.*;

public class Event extends Task {
    private final String from;
    private final String to;

    public Event(String description, String from, String to) {
        super(description);
        this.from = from;
        this.to = to;
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
    public static void addEvent(String[] inputParts) {
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
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.EVENT_MISSING);
            return;
        }

        TrashpanMain.tasks[TrashpanMain.listCounter] = new Event(description, from, to);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
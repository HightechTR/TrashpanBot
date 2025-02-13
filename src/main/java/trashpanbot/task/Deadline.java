package trashpanbot.task;

import trashpanbot.*;

public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDate() {
        return " (by: " + deadline + ")";
    }

    /**
     * Adds a deadline to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static void addDeadline(String[] inputParts) {
        // check if list is full
        if (isListFull()) {
            return;
        }

        // check if parameter is non-empty
        if (inputParts.length != 2 || inputParts[1].isEmpty()) {
            System.out.println(Text.DEADLINE_NO_DESC);
            return;
        }

        String[] parameterParts = inputParts[1].split(" /by ", 2);

        // check if due date is valid
        if (parameterParts.length != 2 || parameterParts[1].isEmpty()) {
            System.out.println(Text.DEADLINE_NO_DATE);
            return;
        }

        String description = parameterParts[0];
        String deadline = parameterParts[1];
        TrashpanMain.tasks[TrashpanMain.listCounter] = new Deadline(description, deadline);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
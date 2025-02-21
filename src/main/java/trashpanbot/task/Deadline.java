package trashpanbot.task;

import java.io.IOException;

import trashpanbot.*;
import trashpanbot.save.Save;

public class Deadline extends Task {
    private final String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public String getDeadline() {
        return deadline;
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
    public static void addDeadline(String[] inputParts, boolean isNotSaveLoad) throws IOException {
        String[] parameterParts;
        String description;
        String deadline;

        // check if parameters are non-empty
        try {
            parameterParts = inputParts[1].split(" /by ", 2);
            description = checkEmpty(parameterParts[0]);
            deadline = checkEmpty(parameterParts[1]);
        } catch (IndexOutOfBoundsException e) {
            if (isNotSaveLoad) {
                System.out.println(Text.DEADLINE_MISSING);
                return;
            } else {
                throw new IOException();
            }
        }

        TrashpanMain.tasks.add(new Deadline(description, deadline));

        if (isNotSaveLoad) {
            printAddedText();
            Save.updateFile(TrashpanMain.filePath);
        }
    }
}
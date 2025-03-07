package trashpanbot.data.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parent abstract class for all <code>Task</code> objects.
 */
public abstract class Task {
    private final String description;
    private boolean isDone;

    protected static final DateTimeFormatter DATE_OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    /**
     * Gets the description of the task.
     *
     * @return The task description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the status icon of the task corresponding to whether it is done or not.
     *
     * @return "X" if the task is marked done, " " otherwise.
     */
    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    /**
     * Gets the due date from a deadline task.
     *
     * @return The date and time of the deadline task.
     */
    public LocalDateTime getDeadline() {
        return null;
    }

    /**
     * Gets the start date from an event task.
     *
     * @return The start date and time of the event task.
     */
    public LocalDateTime getFrom() {
        return null;
    }

    /**
     * Gets the end date from an event task.
     *
     * @return The end date and time of the event task.
     */
    public LocalDateTime getTo() {
        return null;
    }

    /**
     * Gets the type icon corresponding to the task type.
     *
     * @return "T" for a to-do, "D" for a deadline, "E" for an event task.
     */
    public abstract String getTypeIcon();

    /**
     * Gets the due date or start and end dates in a format to be printed.
     *
     * @return A String representing the dates to be printed.
     */
    public abstract String getDate();

    /**
     * Sets the isDone status of the task.
     *
     * @param done Value to set.
     */
    public void setDone(boolean done) {
        this.isDone = done;
    }
}
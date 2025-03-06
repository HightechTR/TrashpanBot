package trashpanbot.data.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Task {
    private final String description;
    private boolean isDone;

    protected static final DateTimeFormatter DATE_OUTPUT_FORMAT =
            DateTimeFormatter.ofPattern("d MMM yyyy HH:mm");

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public LocalDateTime getDeadline() {
        return null;
    }

    public LocalDateTime getFrom() {
        return null;
    }

    public LocalDateTime getTo() {
        return null;
    }

    public abstract String getTypeIcon();

    public abstract String getDate();

    public void setDone(boolean done) {
        this.isDone = done;
    }
}
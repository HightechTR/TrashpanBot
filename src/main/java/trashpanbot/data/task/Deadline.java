package trashpanbot.data.task;

import java.time.LocalDateTime;

/**
 * Represents deadline tasks.
 * A <code>Deadline</code> object corresponds to a task with a description and a due date.
 */
public class Deadline extends Task {
    private LocalDateTime deadline;

    public Deadline(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    @Override
    public LocalDateTime getDeadline() {
        return deadline;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDate() {
        return " (by: " + deadline.format(dateOutputFormat) + ")";
    }
}
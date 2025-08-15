package trashpanbot.data.task;

import java.time.LocalDateTime;

/**
 * Represents event tasks.
 * A <code>Event</code> object corresponds to a task with a description, a start date
 * and an end date.
 */
public class Event extends Task {
    private LocalDateTime from;
    private LocalDateTime to;

    public Event(String description, LocalDateTime from, LocalDateTime to) {
        super(description);
        this.from = from;
        this.to = to;
    }

    @Override
    public LocalDateTime getFrom() {
        return from;
    }

    @Override
    public LocalDateTime getTo() {
        return to;
    }

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDate() {
        return " (from: "
                + from.format(dateOutputFormat) + " to: "
                + to.format(dateOutputFormat) + ")";
    }
}
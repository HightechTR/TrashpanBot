package trashpanbot.data.task;

import java.time.LocalDateTime;

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
                + from.format(DATE_OUTPUT_FORMAT) + " to: "
                + to.format(DATE_OUTPUT_FORMAT) + ")";
    }
}
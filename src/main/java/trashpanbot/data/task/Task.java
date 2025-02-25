package trashpanbot.data.task;

public abstract class Task {
    private final String description;
    private boolean isDone;

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

    public String getDeadline() {
        return "";
    }

    public String getFrom() {
        return "";
    }

    public String getTo() {
        return "";
    }

    public abstract String getTypeIcon();

    public abstract String getDate();

    public void setDone(boolean done) {
        this.isDone = done;
    }
}
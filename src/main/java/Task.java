public class Task {
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public String getTypeIcon() {
        return "";
    }

    public String getDate() {
        return "";
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}

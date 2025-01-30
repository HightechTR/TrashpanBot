public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String name) {
        this.description = name;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }
}

public class Task {
    protected String description;
    protected boolean done;

    public Task(String name) {
        this.description = name;
        this.done = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return done ? "X" : " ";
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}

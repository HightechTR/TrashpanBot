package trashpanbot.data.task;

/**
 * Represents to-do tasks.
 * A <code>To-do</code> object corresponds to a task with only a description.
 */
public class Todo extends Task {
    public Todo(String description) {
        super(description);
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }

    public String getDate() {
        return "";
    }
}
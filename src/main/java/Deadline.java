public class Deadline extends Todo {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        super.setDone(false);
        this.deadline = deadline;
    }

    @Override
    public String getTypeIcon() {
        return "D";
    }

    @Override
    public String getDate() {
        return "(by: " + deadline + ")";
    }
}

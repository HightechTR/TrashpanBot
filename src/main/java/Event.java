public class Event extends Todo {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        super.setDone(false);
        this.from = from;
        this.to = to;
    }

    @Override
    public String getTypeIcon() {
        return "E";
    }

    @Override
    public String getDate() {
        return "(from: " + from + " to: " + to + ")";
    }
}


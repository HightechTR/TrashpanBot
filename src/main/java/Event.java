public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to) {
        super(description);
        super.isDone = false;
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

    /**
     * Adds an event to the list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static void addEvent(String[] inputParts) {
        // check if list is full
        if (isListFull()) {
            return;
        }

        // check if parameter is non-empty
        if (inputParts.length != 2 || inputParts[1].isEmpty()) {
            System.out.println(Text.EVENT_NO_DESC);
            return;
        }

        String[] parameterParts = inputParts[1].split(" /from | /to ", 3);

        // check if start and end date is valid
        if (parameterParts.length != 3 || parameterParts[1].isEmpty() || parameterParts[2].isEmpty()) {
            System.out.println(Text.EVENT_NO_DATE);
            return;
        }

        String description = parameterParts[0];
        String from = parameterParts[1];
        String to = parameterParts[2];

        TrashpanMain.tasks[TrashpanMain.listCounter] = new Event(description, from, to);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
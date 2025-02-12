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
        return " (from: " + from + " to: " + to + ")";
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

        String[] parameterParts;
        String description;

        // check if parameter is non-empty
        try {
            parameterParts = inputParts[1].split(" /from | /to ", 3);
            description = checkEmpty(parameterParts[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.EVENT_NO_DESC);
            return;
        }

        String from;
        String to;

        // check if start and end date is valid
        try {
            from = checkEmpty(parameterParts[1]);
            to = checkEmpty(parameterParts[2]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.EVENT_NO_DATE);
            return;
        }

        TrashpanMain.tasks[TrashpanMain.listCounter] = new Event(description, from, to);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
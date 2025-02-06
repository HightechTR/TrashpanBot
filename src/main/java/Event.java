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
     * @param input The input string containing the task to be added to the list.
     */
    public static void addEvent(String input) {
        String parameter = Todo.getParameter(input);

        // check if parameter is non-empty
        if (Todo.isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");
            return;
        }

        String from = parameter.substring(parameter.indexOf("/from") + 5);
        String to = parameter.substring(parameter.indexOf("/to") + 3);

        // check if start and end date is valid
        if (!parameter.contains("/from") || from.length() < 2) {
            System.out.println("Oops, you didn't give me the start date!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");
        } else if (!parameter.contains("/to") || to.length() < 2) {
            System.out.println("Oops, you didn't give me the end date!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");

        } else if (isListNotFull()) {
            String description = parameter.substring(0, parameter.indexOf("/from"));
            tasks[listCounter] = new Event(description, from.substring(1, from.indexOf("/to") - 1), to.substring(1));
            listCounter++;
            printAddedText();
        }
    }
}
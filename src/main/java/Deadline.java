public class Deadline extends Task {
    protected String deadline;

    public Deadline(String description, String deadline) {
        super(description);
        super.isDone = false;
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

    /**
     * Adds a deadline to the task list.
     *
     * @param input The input string containing the task to be added to the list.
     */
    public static void addDeadline(String input) {
        String parameter = Todo.getParameter(input);

        // check if parameter is non-empty
        if (Todo.isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: deadline <description> /by <due date>");
            return;
        }

        String deadline = parameter.substring(parameter.indexOf("/by") + 3);

        // check if due date is valid
        if (!parameter.contains("/by") || deadline.length() < 2) {
            System.out.println("Oops, you didn't give me a date!");
            System.out.println("Command format: deadline <description> /by <due date>");

        } else if (isListNotFull()) {
            String description = parameter.substring(0, parameter.indexOf("/by"));
            tasks[listCounter] = new Deadline(description, deadline.substring(1));
            listCounter++;
            printAddedText();
        }
    }
}
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
        return " (by: " + deadline + ")";
    }

    /**
     * Adds a deadline to the task list.
     *
     * @param inputParts The input string array containing the task to be added to the list.
     */
    public static void addDeadline(String[] inputParts) {
        // check if list is full
        if (isListFull()) {
            return;
        }

        String[] parameterParts;
        String description;

        // check if parameter is non-empty
        try {
            parameterParts = inputParts[1].split(" /by ", 2);
            description = checkEmpty(parameterParts[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.DEADLINE_NO_DESC);
            return;
        }

        String deadline;

        // check if due date is valid
        try {
            deadline = checkEmpty(parameterParts[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(Text.DEADLINE_NO_DATE);
            return;
        }

        TrashpanMain.tasks[TrashpanMain.listCounter] = new Deadline(description, deadline);
        TrashpanMain.listCounter++;
        printAddedText();
    }
}
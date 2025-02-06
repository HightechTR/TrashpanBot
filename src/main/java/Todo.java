public class Todo extends Task {
    public Todo(String description) {
        super(description);
        super.isDone = false;
    }

    @Override
    public String getTypeIcon() {
        return "T";
    }

    /**
     * Extracts task description from command.
     *
     * @param input The input string.
     * @return The description of the task.
     */
    static String getParameter(String input) {
        return input.substring(input.indexOf(" ") + 1);
    }

    /**
     * Checks if input parameters are non-empty.
     *
     * @param input The input string containing command and parameter.
     * @return True if parameter is non-empty.
     */
    public static boolean isInvalidParameter(String input) {
        String parameter = getParameter(input);
        return !input.contains(" ") || parameter.isEmpty();
    }

    /**
     * Adds a task to the task list.
     *
     * @param input The input string containing the task to be added to the list.
     */
    public static void addTodo(String input) {
        String description = getParameter(input);

        // check if parameter is non-empty
        if (isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: todo <description>");

        } else if (isListNotFull()) {
            tasks[listCounter] = new Todo(description);
            listCounter++;
            printAddedText();
        }
    }
}

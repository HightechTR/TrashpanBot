public class Task {
    static final int MAX_TASKS = 100;
    static final Task[] tasks = new Task[MAX_TASKS];
    static int listCounter = 0;
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return isDone ? "X" : " ";
    }

    public String getTypeIcon() {
        return "";
    }

    public String getDate() {
        return "";
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    /**
     * Parses the input string into an integer.
     * Returns null if the string is not an integer.
     *
     * @param input Input string.
     * @return Integer corresponding to string, null if string is not an integer.
     */
    public static Integer tryParseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Checks if the list is full (100 tasks).
     *
     * @return True if the list is full.
     */
    public static boolean isListFull() {
        if (listCounter > 99) {
            System.out.println(Text.TASK_LIST_FULL);
        }
        return listCounter > 99;
    }

    /**
     * Prints a task with its type and dates (if any).
     *
     * @param i The index of the task to be printed.
     */
    private static void printTask(int i) {
        System.out.print(i + ".[" + tasks[i - 1].getTypeIcon() + "]");
        System.out.print("[" + tasks[i - 1].getStatusIcon() + "] ");
        System.out.println(tasks[i - 1].getDescription() + tasks[i - 1].getDate());
    }

    /**
     * Displays task list to the output.
     */
    public static void displayList() {
        if (listCounter == 0) {
            System.out.println(Text.TASK_LIST_EMPTY);
        } else {
            System.out.println(Text.TASK_LIST_DISPLAY);
            for (int i = 1; i <= listCounter; i++) {
                printTask(i);
            }
        }
    }

    /**
     * Prints most recent task after adding.
     */
    static void printAddedText() {
        System.out.println(Text.TASK_ADDED);
        printTask(listCounter);
        System.out.print("You have " + listCounter + " ");
        System.out.println(listCounter == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Marks a task as done or not done in the list.
     *
     * @param inputParts The input string array containing the task index to be marked.
     * @param isDone Boolean to set the task as done or not done.
     */
    public static void markDone(String[] inputParts, boolean isDone) {
        Integer index = tryParseInteger(inputParts[1]);

        if (index == null) { // check if number is valid
            System.out.println(Text.TASK_MARK_NO_NUM);

        } else if (index > listCounter) { // check if number is in bounds
            System.out.println(Text.TASK_MARK_OOB);

        } else {
            tasks[index - 1].setDone(isDone);
            System.out.println(isDone ? Text.TASK_MARK_DONE : Text.TASK_MARK_UNDONE);
            printTask(index);
        }
    }
}

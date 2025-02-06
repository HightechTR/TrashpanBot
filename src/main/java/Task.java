public class Task {
    static int listCounter = 0;
    static Task[] tasks = new Task[100];
    protected String description;
    protected boolean isDone;

    public Task (String description) {
        this.description = description;
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
    public static boolean isListNotFull() {
        if (listCounter > 99) {
            System.out.println("Sorry! The list is full!");
        }
        return listCounter <= 99;
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
            System.out.println("Your list is empty!");
        } else {
            System.out.println("Okay, here's your list:");
            for (int i = 1; i <= listCounter; i++) {
                printTask(i);
            }
        }
    }

    /**
     * Prints most recent task after adding.
     */
    static void printAddedText() {
        System.out.println("Okay! Added this to the list:");
        printTask(listCounter);
        System.out.print("You have " + listCounter + " ");
        System.out.println(listCounter == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Marks a task as done in the list.
     *
     * @param input The command containing the task index to be marked done;
     *              must contain "mark".
     */
    public static void markDone(String input) {
        Integer index = tryParseInteger(input.substring(input.indexOf(" ") + 1));
        if (index == null) {
            System.out.println("Oops! That's not a number.");
        } else if (index > listCounter) {
            System.out.println("Oops! That's not in the list.");
        } else {
            tasks[index - 1].setDone(true);
            System.out.println("Yay! I've marked this task as done:");
            printTask(index);
        }
    }

    /**
     * Marks a task as not done in the list.
     *
     * @param input The command containing the task index to be marked not done;
     *              must contain "unmark".
     */
    public static void markNotDone(String input) {
        Integer index = tryParseInteger(input.substring(input.indexOf(" ") + 1));
        if (index == null) {
            System.out.println("Oops! That's not a number.");
        } else if (index > listCounter) {
            System.out.println("Oops! That's not in the list.");
        } else {
            tasks[index - 1].setDone(false);
            System.out.println("Ganbaraki! I've unmarked this task as not done:");
            printTask(index);
        }
    }
}

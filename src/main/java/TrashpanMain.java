import java.util.Scanner;

public class TrashpanMain {
    static String input;
    static int listCounter = 0;
    static Todo[] tasks = new Todo[100];

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
     * Extracts task description from command.
     *
     * @param input The input string.
     * @return The description of the task.
     */
    private static String getParameter(String input) {
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
     * Checks if the list is full (100 tasks).
     *
     * @return True if the list is full.
     */
    public static boolean checkIfListIsNotFull() {
        if (listCounter > 99) {
            System.out.println("Sorry! The list is full!");
        }
        return listCounter <= 99;
    }

    /**
     * Reads an input, extracts and returns first word as a command.
     *
     * @return The first word of the input.
     */
    private static String getCommand() {
        Scanner in = new Scanner(System.in);
        String command;

        input = in.nextLine();
        command = input.contains(" ") ? input.substring(0, input.indexOf(" ")) : input;
        return command;
    }

    /**
     * Calls methods for the task list based on the command inputted.
     */
    public static void parseTaskListCommand() {
        String command;

        while (true) {
            System.out.println(Text.TEXT_LINE);
            command = getCommand();
            System.out.println(Text.TEXT_LINE);

            switch (command) {
            case "todo":
                addTodo(input);
                break;

            case "deadline":
                addDeadline(input);
                break;

            case "event":
                addEvent(input);
                break;

            case "list":
                displayList();
                break;

            case "mark":
                markDone(input);
                break;

            case "unmark":
                markNotDone(input);
                break;

            case "help":
                System.out.println(Text.TEXT_TASK_LIST_COMMANDS);
                break;

            case "bye":
                return;

            default:
                System.out.println("I don't recognise that command!");
                break;
            }
        }
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
    private static void printAddedText() {
        System.out.println("Okay! Added this to the list:");
        printTask(listCounter);
        System.out.print("You have " + listCounter + " ");
        System.out.println(listCounter == 1 ? "task now!" : "tasks now!");
    }

    /**
     * Adds a task to the task list.
     *
     * @param input The input string containing the task to be added to the list.
     */
    public static void addTodo(String input) {
        String description = getParameter(input);
        if (isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: todo <description>");
        } else if (checkIfListIsNotFull()) {
            tasks[listCounter] = new Todo(description);
            listCounter++;
            printAddedText();
        }
    }

    /**
     * Adds a deadline to the task list.
     *
     * @param input The input string containing the task to be added to the list.
     */
    public static void addDeadline(String input) {
        String parameter = getParameter(input);
        String deadline = parameter.substring(parameter.indexOf("/by") + 3);
        if (isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: deadline <description> /by <due date>");
        } else if (!parameter.contains("/by") || deadline.length() < 2) {
            System.out.println("Oops, you didn't give me a date!");
            System.out.println("Command format: deadline <description> /by <due date>");

        } else if (checkIfListIsNotFull()) {
            String description = parameter.substring(0, parameter.indexOf("/by"));
            tasks[listCounter] = new Deadline(description, deadline.substring(1));
            listCounter++;
            printAddedText();
        }
    }

    /**
     * Adds an event to the list.
     *
     * @param input The input string containing the task to be added to the list.
     */
    public static void addEvent(String input) {
        String parameter = getParameter(input);
        String from = parameter.substring(parameter.indexOf("/from") + 5);
        String to = parameter.substring(parameter.indexOf("/to") + 3);
        if (isInvalidParameter(input)) {
            System.out.println("Oops, you didn't say what to add!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");
        } else if (!parameter.contains("/from") || from.length() < 2) {
            System.out.println("Oops, you didn't give me the start date!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");
        } else if (!parameter.contains("/to") || to.length() < 2) {
            System.out.println("Oops, you didn't give me the end date!");
            System.out.println("Command format: event <description> /from <start date> /to <end date>");

        } else if (checkIfListIsNotFull()) {
            String description = parameter.substring(0, parameter.indexOf("/from"));
            tasks[listCounter] = new Event(description, from.substring(1, from.indexOf("/to") - 1), to.substring(1));
            listCounter++;
            printAddedText();
        }
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
            tasks[--index].setDone(false);
            System.out.println("Ganbaraki! I've unmarked this task as not done:");
            System.out.println("[ ] " + tasks[index].getDescription());
        }
    }

    public static void main(String[] args) {
        System.out.println(Text.TEXT_INTRO);

        System.out.println(Text.TEXT_TASK_LIST);
        System.out.println(Text.TEXT_TASK_LIST_COMMANDS);
        parseTaskListCommand();

        System.out.println(Text.TEXT_BYE);
    }
}
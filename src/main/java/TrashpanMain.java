import java.util.Scanner;

public class TrashpanMain {
    static int listCounter = 0;
    static Task[] tasks = new Task[100];

    /**
     * Parses the input string into an integer.
     * Returns null if the string is not an integer.
     *
     * @param input Input string.
     * @return Integer corresponding to string, null if string is not an integer.
     */
    public static Integer tryParse(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Parses input into a command to be interpreted.
     */
    public static void parseInput() {
        String input;
        String command;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(TrashpanText.TEXT_LINE);
            input = in.nextLine();
            command = input.contains(" ") ? input.substring(0, input.indexOf(" ")) : input;
            System.out.println(TrashpanText.TEXT_LINE);

            switch (command) {
            case "list":
                displayList();
                break;

            case "mark":
                markDone(input);
                break;

            case "unmark":
                markNotDone(input);
                break;

            case "bye":
                return;

            default:
                addTask(input);
            }
        }
    }

    /**
     * Displays task list to the output.
     */
    public static void displayList() {
        System.out.println("Here's your list:");
        for (int i = 1; i <= listCounter; i++) {
            System.out.print(i + ".[" + tasks[i - 1].getStatusIcon() + "] ");
            System.out.println(tasks[i - 1].getDescription());
        }
    }

    /**
     * Adds a task to the task list.
     *
     * @param input The task to be added to the list.
     */
    public static void addTask(String input) {
        if (listCounter > 99) {
            System.out.println("Sorry! The list is full!");
        } else {
            tasks[listCounter] = new Task(input);
            listCounter++;
            System.out.println("Okay! Added \"" + input + "\" to the list.");
        }
    }

    /**
     * Marks a task as done in the list.
     *
     * @param input The command containing the task index to be marked done;
     *              must contain "mark".
     */
    public static void markDone(String input) {
        Integer index = tryParse(input.substring(input.indexOf(" ") + 1));
        if (index == null) {
            System.out.println("Oops! That's not a number.");
        } else if (index > listCounter) {
            System.out.println("Oops! That's not in the list.");
        } else {
            tasks[--index].setDone(true);
            System.out.println("Yay! I've marked this task as done:");
            System.out.println("[X] " + tasks[index].getDescription());
        }
    }

    /**
     * Marks a task as not done in the list.
     *
     * @param input The command containing the task index to be marked not done;
     *              must contain "unmark".
     */
    public static void markNotDone(String input) {
        Integer index = tryParse(input.substring(input.indexOf(" ") + 1));
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
        System.out.println(TrashpanText.TEXT_INTRO);

        System.out.println(TrashpanText.TEXT_TASK_LIST);

        parseInput();

        System.out.println(TrashpanText.TEXT_BYE);
    }
}
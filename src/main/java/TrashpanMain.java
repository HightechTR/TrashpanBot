import java.util.Scanner;

public class TrashpanMain {
    static final int MAX_TASKS = 100;
    static final Task[] tasks = new Task[MAX_TASKS];

    static String userInput;
    static Scanner in = new Scanner(System.in);
    static boolean isRunning = true;
    static int listCounter = 0;

    /**
     * Reads in an input and parses it into command and parameter.
     *
     * @return The string array containing the command and parameter
     */
    public static String[] readInput() {
        userInput = in.nextLine();
        return userInput.split(" ", 2);
    }

    public static void exitProgram() {
        System.out.println(Text.BYE);
        isRunning = false;
        System.exit(0);
    }

    /**
     * Calls methods for the task list application based on the command inputted.
     */
    public static void parseTaskListCommand() {
        String[] inputParts;
        String command;

        while (isRunning) {
            System.out.println(Text.LINE);
            inputParts = readInput();
            command = inputParts[0];
            System.out.println(Text.LINE);

            switch (command) {
            case "todo" -> Todo.addTodo(inputParts);
            case "event" -> Event.addEvent(inputParts);
            case "list" -> Task.displayList();
            case "mark" -> Task.markTask(inputParts, true);
            case "unmark" -> Task.markTask(inputParts, false);
            case "help" -> System.out.println(Text.TASK_LIST_COMMANDS);
            case "bye" -> exitProgram();
            default -> System.out.println(Text.COMMAND_INVALID);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Text.INTRO);

        System.out.println(Text.TASK_LIST);
        System.out.println(Text.TASK_LIST_COMMANDS);
        parseTaskListCommand();
    }
}
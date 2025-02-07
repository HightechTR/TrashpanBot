import java.util.Scanner;

public class TrashpanMain {
    static String userInput;
    static Scanner in = new Scanner(System.in);

    /**
     * Reads in an input and parses it into command and parameter.
     *
     * @return The string array containing the command and parameter
     */
    public static String[] readInput() {
        userInput = in.nextLine();
        return userInput.split(" ", 2);
    }

    /**
     * Calls methods for the task list application based on the command inputted.
     */
    public static void parseTaskListCommand() {
        String[] inputParts;
        String command;

        while (true) {
            System.out.println(Text.LINE);
            inputParts = readInput();
            command = inputParts[0];
            System.out.println(Text.LINE);

            switch (command) {
            case "todo":
                Todo.addTodo(inputParts);
                break;

            case "deadline":
                Deadline.addDeadline(inputParts);
                break;

            case "event":
                Event.addEvent(inputParts);
                break;

            case "list":
                // ignores any parameters
                Task.displayList();
                break;

            case "mark":
                Task.markDone(inputParts, true);
                break;

            case "unmark":
                Task.markDone(inputParts, false);
                break;

            case "help":
                // ignores any parameters
                System.out.println(Text.TASK_LIST_COMMANDS);
                break;

            case "bye":
                // ignores any parameters
                return;

            default:
                System.out.println(Text.COMMAND_INVALID);
                break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Text.INTRO);

        System.out.println(Text.TASK_LIST);
        System.out.println(Text.TASK_LIST_COMMANDS);
        parseTaskListCommand();

        System.out.println(Text.BYE);
    }
}
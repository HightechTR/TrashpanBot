import java.util.Scanner;

public class TrashpanMain {
    static String userInput;

    /**
     * Reads an input, extracts and returns first word as a command.
     *
     * @return The first word of the input.
     */
    private static String getCommand() {
        Scanner in = new Scanner(System.in);
        String command;

        userInput = in.nextLine();
        command = userInput.contains(" ") ? userInput.substring(0, userInput.indexOf(" ")) : userInput;
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
                Todo.addTodo(userInput);
                break;

            case "deadline":
                Deadline.addDeadline(userInput);
                break;

            case "event":
                Event.addEvent(userInput);
                break;

            case "list":
                Task.displayList();
                break;

            case "mark":
                Task.markDone(userInput);
                break;

            case "unmark":
                Task.markNotDone(userInput);
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

    public static void main(String[] args) {
        System.out.println(Text.TEXT_INTRO);

        System.out.println(Text.TEXT_TASK_LIST);
        System.out.println(Text.TEXT_TASK_LIST_COMMANDS);
        parseTaskListCommand();

        System.out.println(Text.TEXT_BYE);
    }
}
import java.util.Scanner;

public class TrashpanMain {

    static int listCounter = 0;
    static Task[] tasks = new Task[100];

    static final String TEXT_LOGO = """
            ⠀⠀⠀⢠⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣄⠀⠀
            ⠀⠀⠀⢸⣿⣎⢛⡶⠤⣤⣤⣤⣀⣀⡴⠞⣩⣵⣾⡇⠀
            ⠀⠀⠀⠘⣞⡟⠁⠀⠘⠉⠀⠀⠀⠙⠁⣾⣿⣿⣹⠀⠀
            ⠀⠀⠀⣴⢋⣦⡄⢀⠀⠀⢀⣀⣀⠀⠀⠙⢿⣡⠃⠀⠀
            ⠀⣠⡞⣡⣿⠟⣻⡆⣠⣾⠿⠿⣷⣍⠀⠀⠈⢳⡄⠀⠀
            ⢾⣯⠘⣿⡿⣿⣿⡿⢿⣿⣀⣿⣿⣿⣿⡦⠀⠀⠹⣆⠀
            ⠀⠙⢧⣿⣿⣿⠀⠀⠈⠻⢿⣿⣿⣿⡿⠋⠀⠀⢀⣘⣧
            ⠀⠀⠈⠻⣯⣅⠀⠀⣐⣤⠀⠉⠉⠉⠀⢀⣠⡴⠟⠋⠁
            ⠀⠀⠀⠀⠈⢿⣭⣉⣁⣤⠴⠾⠶⠒⠛⠉⠁⠀⠀⠀⠀
            """;

    static final String TEXT_TASK_LIST = """
            Current Mode: To-do List
            A functional to-do list, storing up to 100 tasks.
            Note: This program does not store tasks after exiting.
            
            Commands:
            "list": Displays full list of tasks
            "mark <number>": Marks the task labelled with the number as done
            "unmark <number>": Marks the task labelled with the number as not done
            "bye": Exits the program
            Any other input: Adds the input to the list""";

    static final String TEXT_LINE =
            "__________________________________________________";

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

    public static void parseInput() {
        String input;
        String command;
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println(TEXT_LINE);
            input = in.nextLine();
            command = input.contains(" ") ? input.substring(0, input.indexOf(" ")) : input;
            System.out.println(TEXT_LINE);

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

    public static void displayList() {
        System.out.println("Here's your list:");
        for (int i = 1; i <= listCounter; i++) {
            System.out.print(i + ".[" + tasks[i - 1].getStatusIcon() + "] ");
            System.out.println(tasks[i - 1].getDescription());
        }
    }

    public static void addTask(String input) {
        if (listCounter > 99) {
            System.out.println("Sorry! The list is full!");
        } else {
            tasks[listCounter] = new Task(input);
            listCounter++;
            System.out.println("Okay! Added \"" + input + "\" to the list.");
        }
    }

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

        System.out.println(TEXT_LOGO);
        System.out.println("Raah! I'm TrashpanBot!");
        System.out.println("What can I do for you today?");
        System.out.println(TEXT_LINE);

        System.out.println(TEXT_TASK_LIST);

        parseInput();

        System.out.println("Otsuraki! See you soon!");
        System.out.println(TEXT_LINE);
    }
}
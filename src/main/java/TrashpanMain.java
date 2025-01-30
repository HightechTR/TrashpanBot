import java.util.Scanner;

public class TrashpanMain {
    
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

    public static void main(String[] args) {
        String logo = """
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
        Scanner in = new Scanner(System.in);
        String input;
        String command = "";
        Task[] tasks = new Task[100];
        int listCounter = 0;

        System.out.println(logo);
        System.out.println("Raah! I'm TrashpanBot!");
        System.out.println("What can I do for you today?");
        System.out.println("__________________________________________________");

        System.out.println("""
                Current Mode: To-do List
                A functional to-do list, storing up to 100 tasks.
                Note: This program does not store tasks after exiting.
                
                Commands:
                "list": Displays full list of tasks
                "mark <number>": Marks the task labelled with the number as done
                "unmark <number>": Marks the task labelled with the number as not done
                "bye": Exits the program
                Any other input: Adds the input to the list""");

        while (!command.equals("bye")) {
            System.out.println("__________________________________________________");
            input = in.nextLine();
            command = input.contains(" ") ? input.substring(0, input.indexOf(" ")) : input;
            System.out.println("__________________________________________________");

            switch (command) {
            case "list":
                System.out.println("Here's your list:");
                for (int i = 1; i <= listCounter; i++) {
                    System.out.print(i + ".[" + tasks[i - 1].getStatusIcon() + "] ");
                    System.out.println(tasks[i - 1].getDescription());
                }
                break;

            case "mark":
                Integer index1 = tryParse(input.substring(input.indexOf(" ") + 1));
                if (index1 == null) {
                    System.out.println("Oops! That's not a number.");
                } else if (index1 > listCounter) {
                    System.out.println("Oops! That's not in the list.");
                } else {
                    tasks[--index1].setDone(true);
                    System.out.println("Yay! I've marked this task as done:");
                    System.out.println("[X] " + tasks[index1].getDescription());
                }
                break;

            case "unmark":
                Integer index2 = tryParse(input.substring(input.indexOf(" ") + 1));
                if (index2 == null) {
                    System.out.println("Oops! That's not a number.");
                } else if (index2 > listCounter) {
                    System.out.println("Oops! That's not in the list.");
                } else {
                    tasks[--index2].setDone(false);
                    System.out.println("Ganbaraki! I've unmarked this task as not done:");
                    System.out.println("[ ] " + tasks[index2].getDescription());
                }
                break;

            case "bye":
                break;

            default:
                if (listCounter > 99) {
                    System.out.println("Sorry! The list is full!");
                } else {
                    tasks[listCounter] = new Task(command);
                    listCounter++;
                    System.out.println("Okay! Added \"" + command + "\" to the list.");
                }
            }
        }

        System.out.println("Otsuraki! See you soon!");
        System.out.println("__________________________________________________");
    }
}
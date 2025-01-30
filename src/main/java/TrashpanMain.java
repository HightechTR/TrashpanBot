import java.util.Scanner;

public class TrashpanMain {
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
        String command = "";
        String[] task = new String[100];
        int listCounter = 0;

        System.out.println(logo);
        System.out.println("Raah! I'm TrashpanBot!");
        System.out.println("What can I do for you today?");
        System.out.println("__________________________________________________");
        System.out.println("Current Mode: Task List");
        System.out.println("Input any line to add to list, up to 100 tasks.");
        System.out.println("Commands: \"list\" to display list, \"bye\" to exit");

        while (!command.equals("bye")) {
            System.out.println("__________________________________________________");
            command = in.nextLine();
            System.out.println("__________________________________________________");
            switch (command) {
            case "list":
                System.out.println("Here's your list:");
                for (int i = 1; i <= listCounter; i++) {
                    System.out.print(i + ". ");
                    System.out.println(task[i - 1]);
                }
                break;

            case "bye":
                break;

            default:
                if (listCounter > 99) {
                    System.out.println("Sorry! The list is full!");
                } else {
                    task[listCounter] = command;
                    listCounter++;
                    System.out.println("Okay! Added \"" + command + "\" to the list.");
                }
            }
        }

        System.out.println("Otsuraki! See you soon!");
        System.out.println("__________________________________________________");
    }
}
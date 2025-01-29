import java.util.Scanner;

public class TrashpanMain {
    public static void main(String[] args) {
        String logo = "⠀⠀⠀⢠⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣄⠀⠀\n"
                + "⠀⠀⠀⢸⣿⣎⢛⡶⠤⣤⣤⣤⣀⣀⡴⠞⣩⣵⣾⡇⠀\n"
                + "⠀⠀⠀⠘⣞⡟⠁⠀⠘⠉⠀⠀⠀⠙⠁⣾⣿⣿⣹⠀⠀\n"
                + "⠀⠀⠀⣴⢋⣦⡄⢀⠀⠀⢀⣀⣀⠀⠀⠙⢿⣡⠃⠀⠀\n"
                + "⠀⣠⡞⣡⣿⠟⣻⡆⣠⣾⠿⠿⣷⣍⠀⠀⠈⢳⡄⠀⠀\n"
                + "⢾⣯⠘⣿⡿⣿⣿⡿⢿⣿⣀⣿⣿⣿⣿⡦⠀⠀⠹⣆⠀\n"
                + "⠀⠙⢧⣿⣿⣿⠀⠀⠈⠻⢿⣿⣿⣿⡿⠋⠀⠀⢀⣘⣧\n"
                + "⠀⠀⠈⠻⣯⣅⠀⠀⣐⣤⠀⠉⠉⠉⠀⢀⣠⡴⠟⠋⠁\n"
                + "⠀⠀⠀⠀⠈⢿⣭⣉⣁⣤⠴⠾⠶⠒⠛⠉⠁⠀⠀⠀⠀\n";
        Scanner in = new Scanner(System.in);
        System.out.println(logo);
        System.out.println("Raah! I'm TrashpanBot!");
        System.out.println("What can I do for you today?");
        System.out.println("__________________________________________________");
        String command = "";
        while (!command.equals("bye")) {
            command = in.nextLine();
            System.out.println("__________________________________________________");
            if (!command.equals("bye")) {
                System.out.println(command);
                System.out.println("__________________________________________________");
            }
        }
        System.out.println("Otsuraki! See you soon!");
        System.out.println("__________________________________________________");
    }
}
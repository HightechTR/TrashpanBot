public final class Text {
    private Text() {
    }

    public static final String TEXT_TASK_LIST = """
            Current Mode: To-do List
            A functional to-do list, storing up to 100 tasks.
            Note: This program does not store tasks after exiting.""";

    public static final String TEXT_TASK_LIST_COMMANDS = """
            Commands:
            "todo <description>": Adds a todo task to the list
            "deadline <description> /by <due date>": Adds a deadline task to the list
            "event <description> /from <start date> /to <end date>": Adds a event task to the list
            "list": Displays full list of tasks
            "mark <number>": Marks the task labelled with the number as done
            "unmark <number>": Marks the task labelled with the number as not done
            "help": Displays this command list
            "bye": Exits the program""";

    public static final String TEXT_INTRO = """
            This bot is based on the personality of Raki Kazuki from PixelLink.
            ⠀⠀⠀⢠⠤⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣄⠀⠀
            ⠀⠀⠀⢸⣿⣎⢛⡶⠤⣤⣤⣤⣀⣀⡴⠞⣩⣵⣾⡇⠀
            ⠀⠀⠀⠘⣞⡟⠁⠀⠘⠉⠀⠀⠀⠙⠁⣾⣿⣿⣹⠀⠀
            ⠀⠀⠀⣴⢋⣦⡄⢀⠀⠀⢀⣀⣀⠀⠀⠙⢿⣡⠃⠀⠀
            ⠀⣠⡞⣡⣿⠟⣻⡆⣠⣾⠿⠿⣷⣍⠀⠀⠈⢳⡄⠀⠀
            ⢾⣯⠘⣿⡿⣿⣿⡿⢿⣿⣀⣿⣿⣿⣿⡦⠀⠀⠹⣆⠀
            ⠀⠙⢧⣿⣿⣿⠀⠀⠈⠻⢿⣿⣿⣿⡿⠋⠀⠀⢀⣘⣧
            ⠀⠀⠈⠻⣯⣅⠀⠀⣐⣤⠀⠉⠉⠉⠀⢀⣠⡴⠟⠋⠁
            ⠀⠀⠀⠀⠈⢿⣭⣉⣁⣤⠴⠾⠶⠒⠛⠉⠁⠀⠀⠀⠀
            
            Raah! I'm TrashpanBot!
            What can I do for you today?
            __________________________________________________
            """;

    public static final String TEXT_BYE = """
            Otsuraki! See you soon!
            __________________________________________________
            """;

    public static final String TEXT_LINE =
            "__________________________________________________";
}

public final class Text {
    private Text() {
    }

    public static final String TASK_LIST = """
            Current Mode: To-do List
            A functional to-do list, storing up to 100 tasks.
            Note: This program does not store tasks after exiting.""";

    public static final String TASK_LIST_COMMANDS = """
            Commands:
            "todo <description>": Adds a todo task to the list
            "deadline <description> /by <due date>": Adds a deadline task to the list
            "event <description> /from <start date> /to <end date>": Adds a event task to the list
            "list": Displays full list of tasks
            "mark <number>": Marks the task labelled with the number as done
            "unmark <number>": Marks the task labelled with the number as not done
            "help": Displays this command list
            "bye": Exits the program""";

    public static final String TASK_LIST_FULL = "Sorry! The list is full!";

    public static final String TASK_LIST_EMPTY = "Your list is empty!";

    public static final String TASK_LIST_DISPLAY = "Okay, here's your list:";

    public static final String TASK_ADDED = "Okay! Added this to the list:";

    public static final String TASK_MARK_NO_NUM = """
            Oops! That's not a number.
            Command format: mark <number>
            """;

    public static final String TASK_MARK_OOB = "Oops! That's not in the list.";

    public static final String TASK_MARK_DONE = "Yay! I've marked this task as done:";

    public static final String TASK_MARK_UNDONE = "Ganbaraki! I've unmarked this task as not done:";

    public static final String TODO_NO_DESC = """
            Oops, you didn't say what to add!
            Command format: todo <description>""";

    public static final String DEADLINE_NO_DESC = """
            Oops, you didn't say what to add!
            Command format: deadline <description> /by <due date>""";

    public static final String DEADLINE_NO_DATE = """
            Oops, you didn't give me a date!
            Command format: deadline <description> /by <due date>""";

    public static final String EVENT_NO_DESC = """
            Oops, you didn't say what to add!
            Command format: event <description> /from <start date> /to <end date>""";

    public static final String EVENT_NO_DATE = """
            Oops, you didn't give me the start or end date!
            Command format: event <description> /from <start date> /to <end date>""";

    public static final String COMMAND_INVALID = "I don't recognise that command!";

    public static final String INTRO = """
            This bot is based on the personality of Raki Kazuki from PixelLink.
            ⣿⣿⣿⡟⣛⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠻⣿⣿
            ⣿⣿⣿⡇⠀⠱⡤⢉⣛⠛⠛⠛⠿⠿⢋⣡⠖⠊⠁⢸⣿
            ⣿⣿⣿⣧⠡⢠⣾⣿⣧⣶⣿⣿⣿⣦⣾⠁⠀⠀⠆⣿⣿
            ⣿⣿⣿⠋⡴⠙⢻⡿⣿⣿⡿⠿⠿⣿⣿⣦⡀⠞⣼⣿⣿
            ⣿⠟⢡⠞⠀⣠⠄⢹⠟⠁⣀⣀⠈⠲⣿⣿⣷⡌⢻⣿⣿
            ⡁⠐⣧⠀⢀⠀⠀⢀⡀⠀⠿⠀⠀⠀⠀⢙⣿⣿⣆⠹⣿⣿
            ⣿⣦⡘⠀⠀⠀⣿⣿⣷⣄⡀⠀⠀⠀⢀⣴⣿⣿⡿⠧⠘
            ⣿⣿⣷⣄⠐⠺⣿⣿⠯⠛⣿⣶⣶⣶⣿⡿⠟⢋⣠⣴⣾
            ⣿⣿⣿⣿⣷⡀⠒⠶⠾⠛⣋⣁⣉⣭⣤⣶⣾⣿⣿⣿⣿
            
            Raah! I'm TrashpanBot!
            What can I do for you today?
            __________________________________________________
            """;

    public static final String BYE = """
            Otsuraki! See you soon!
            __________________________________________________
            """;

    public static final String LINE =
            "__________________________________________________";
}

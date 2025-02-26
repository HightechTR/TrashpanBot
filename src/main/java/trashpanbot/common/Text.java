package trashpanbot.common;

public final class Text {
    private Text() {
    }

    /*
    =================================================================================
    Task-related Text
    =================================================================================
     */

    public static final String TASK_LIST_DISPLAY = "Okay, here's your list:";

    public static final String TASK_ADDED = "Okay! I added this to the list:";

    public static final String TASK_REMOVED = "Okay! I threw this task into the bin:";

    public static final String TASK_MARK_DONE = "Yay! I've marked this task as done:";

    public static final String TASK_MARK_UNDONE = "Ganbaraki! I've marked this task as not done:";

    /*
    =================================================================================
    Task Input Error Text
    =================================================================================
     */

    public static final String TASK_LIST_EMPTY = "Your list is empty! Try adding a task!";

    public static final String TASK_OOB = "Hey, that's not in your list!";

    public static final String TASK_MARK_NO_NUM = """
            Eh? Something is missing...
            Command format: mark <number>
                <number> - The number of the task in the last shown list""";

    public static final String TASK_MARK_NOT_NUM = """
            Eh? That's not a valid number...
            Command format: mark <number>
                <number> - The number of the task in the last shown list""";

    public static final String TODO_MISSING = """
            Eh? Something is missing...
            Command format: todo <description>
                <description> - The description of the task to be added""";

    public static final String DEADLINE_MISSING = """
            Eh? Something is missing...
            Command format: deadline <description> /by <due date>
                <description> - The description of the task to be added
                <due date> - The due date of the deadline""";

    public static final String EVENT_MISSING = """
            Eh? Something is missing...
            Command format: event <description> /from <start date> /to <end date>
                <description> - The description of the task to be added
                <start date> - The start date of the event
                <end date> - The end date of the event""";

    public static final String COMMAND_INVALID = """
            Eh? I don't know what that means...
            Try running help for the list of commands!""";

    /*
    =================================================================================
    File-related Text
    =================================================================================
     */

    public static final String FILE_READING = """
            Look, I found a save file!
            Loading it for you...
            """;

    public static final String FILE_CREATE = """
            Uh...I couldn't find a save file...
            No worries, I'll create one for you!
            """;

    public static final String FILE_READ_ERROR = """
            Eh? Something's wrong with the save file, it's all gibberish!
            Here, I'll create a new one for you.
            """;

    public static final String FILE_WRITE_ERROR = """
            Hey, I couldn't save to the save file!
            Please check if the data folder exists or the file is corrupted!
            """;

    public static final String FILE_UNKNOWN_ERROR = """
            Uh oh, I couldn't create a new save file for some reason!
            """;

    /*
    =================================================================================
    General Text
    =================================================================================
     */

    public static final String INTRO = """
            __________________________________________________
            
            This bot is based on the personality of Raki Kazuki from PixelLink.
            
                   .##+-                         -####
                  ##   .####                  ###   .##
                  ##  ##   ###################  ###  ##
                  ##  #####                   #####  ##
                   ##  ##                        #  ##
                   ###                              ###
                 ###        -#####      +#####        ###
               ###      -#########      #########+     ###
              ##       ####   ###       ####   ####      ###
            ###        #########          #########       ###
              ###        #####    ######     ###-          ##
                ####                                    ####
                   ####                            #####
                    ##                             ##
            
            Raah! I'm TrashpanBot!
            What can I do for you today?
            __________________________________________________
            """;

    public static final String TASK_LIST = """
            Current Mode: Task List
            I'll keep track of a list of to-dos, deadlines and events for you!
            Don't worry about your data, I'll save it automatically for you!
            __________________________________________________
            """;

    public static final String TASK_LIST_COMMANDS = """
            Commands:
            "todo <description>": Adds a todo task to the list
                <description> - The description of the task to be added
            "deadline <description> /by <due date>": Adds a deadline task to the list
                <description> - The description of the task to be added
                <due date> - The due date of the deadline
            "event <description> /from <start date> /to <end date>": Adds a event task to the list
                <description> - The description of the task to be added
                <start date> - The start date of the deadline
                <end date> - The end date of the deadline
            "list": Displays full list of tasks
            "remove <number>": Removes the task labelled with the number
                <number> - The number of the task in the last shown list
            "mark <number>": Marks the task labelled with the number as done
                <number> - The number of the task in the last shown list
            "unmark <number>": Marks the task labelled with the number as not done
                <number> - The number of the task in the last shown list
            "help": Displays this command list
            "bye": Exits the program""";

    public static final String BYE = """
            Otsuraki! See you soon!
            __________________________________________________
            """;

    public static final String LINE =
            "__________________________________________________" + System.lineSeparator();
}

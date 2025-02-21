package trashpanbot;

public final class Text {
    private Text() {
    }

    public static final String TASK_LIST = """
            Current Mode: To-do List
            A functional to-do list, storing up to 100 tasks.
            Note: This program does not store tasks after exiting.
            __________________________________________________
            """;

    public static final String TASK_LIST_COMMANDS = """
            Commands:
            "todo <description>": Adds a todo task to the list
            "deadline <description> /by <due date>": Adds a deadline task to the list
            "event <description> /from <start date> /to <end date>": Adds a event task to the list
            "list": Displays full list of tasks
            "remove <number>": Removes the task labelled with the number
            "mark <number>": Marks the task labelled with the number as done
            "unmark <number>": Marks the task labelled with the number as not done
            "help": Displays this command list
            "bye": Exits the program""";

    public static final String TASK_LIST_EMPTY = "Your list is empty!";

    public static final String TASK_LIST_DISPLAY = "Okay, here's your list:";

    public static final String TASK_ADDED = "Okay! I added this to the list:";

    public static final String TASK_REMOVED = "Okay! I threw this task into the bin:";

    public static final String TASK_MARK_NO_NUM = """
            Oops, something is missing!
            Command format: mark <number>""";

    public static final String TASK_MARK_NOT_NUM = """
            Oops, that's not a valid number!
            Command format: mark <number>""";

    public static final String TASK_MARK_OOB = "Oops! That's not in the list.";

    public static final String TASK_MARK_DONE = "Yay! I've marked this task as done:";

    public static final String TASK_MARK_UNDONE = "Ganbaraki! I've unmarked this task as not done:";

    public static final String TODO_MISSING = """
            Oops, something is missing!
            Command format: todo <description>""";

    public static final String DEADLINE_MISSING = """
            Oops, something is missing!
            Command format: deadline <description> /by <due date>""";

    public static final String EVENT_MISSING = """
            Oops, something is missing!
            Command format: event <description> /from <start date> /to <end date>""";

    public static final String COMMAND_INVALID = """
            Eh? I don't know what that means...
            Try running help for the list of commands!""";

    public static final String FILE_READING = """
            I found a save file!
            Loading it for you...
            """;

    public static final String FILE_CREATE = """
            I couldn't find a save file...
            No worries, I'll create one for you!
            """;

    public static final String FILE_READ_ERROR = """
            Uh oh, I couldn't read the save file!
            Please check if the file is corrupted and delete it if you have to.""";

    public static final String FILE_WRITE_ERROR = """
            Uh oh, I couldn't save the task list!
            Please check if the file is corrupted and delete it if you have to.""";

    public static final String COMMAND_READ_ERROR = """
            Uh oh, something wrong happened and I don't know what!""";

    public static final String INTRO = """
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

    public static final String BYE = """
            Otsuraki! See you soon!
            __________________________________________________
            """;

    public static final String LINE =
            "__________________________________________________";
}

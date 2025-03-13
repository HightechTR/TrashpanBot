package trashpanbot.common;

/**
 * Represents almost all text printed to the output.
 */
public final class Text {
    private Text() {
    }

    /*
    =================================================================================
    Task-related Text
    =================================================================================
     */

    public static final String TASK_LIST_DISPLAY = "Okay, here's your list:";

    public static final String TASK_FIND_LIST_DISPLAY = "Look, here's what I found:";

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

    public static final String TASK_FIND_LIST_EMPTY =
            "I couldn't find any tasks with that keyword! I hope I didn't lose them...";

    public static final String TASK_OOB = "Hey, that's not in your list!";

    public static final String TASK_MARK_INVALID_NUM = "Eh? That's not a valid number...";

    public static final String TASK_PARAMETER_MISSING = "Eh? Something is missing...";

    public static final String TASK_DATE_FORMAT_ERROR = "Eh? I can't read the date...";

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
            Loading it for you...""";

    public static final String FILE_CREATE = """
            Uh...I couldn't find a save file...
            No worries, I'll create one for you!
            (It's located in [JAR FILE LOCATION]/data/TaskList.txt)""";

    public static final String FILE_READ_ERROR = """
            Eh? Something's wrong with the save file, it's all gibberish!
            Here, I'll create a new one for you.""";

    public static final String FILE_WRITE_ERROR = """
            Hey, I couldn't save to the save file!
            Please check if the data folder exists or the file is corrupted!""";

    public static final String FILE_CREATE_ERROR =
            "Uh oh, I couldn't create a new save file for some reason!";

    /*
    =================================================================================
    General Text
    =================================================================================
     */

    public static final String INTRO = """
            __________________________________________________
            
            This bot is based on the personality of Raki Kazuki, formerly from PixelLink.
            
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
            __________________________________________________
            """;

    public static final String TASK_LIST_DESCRIPTION = """
            I'll keep track of a list of to-dos, deadlines and events for you!
            Don't worry about your data, I'll save it automatically for you!
            
            Run the command "help" to see the list of things I can do!
            For more info on how to use me, go to hightechtr.github.io/ip
            __________________________________________________
            """;

    public static final String EXIT = """
            Otsuraki! See you soon!
            __________________________________________________
            """;

    public static final String LINE =
            "__________________________________________________" + System.lineSeparator();
}

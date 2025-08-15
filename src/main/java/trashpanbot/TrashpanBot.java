package trashpanbot;

import java.io.IOException;
import java.time.format.DateTimeParseException;

import trashpanbot.command.*;
import trashpanbot.common.*;
import trashpanbot.data.io.*;
import trashpanbot.data.task.*;
import trashpanbot.data.save.Save;

public class TrashpanBot {
    private static Ui ui = new Ui();
    private static Parser parser = new Parser(ui);
    private static TaskList tasks;
    private static Save save;

    public static final String FILE_PATH = "data/TaskList.txt";
    public static boolean is24Hour;

    public static void main(String[] args) {
        ui.showIntro();
        save = new Save(FILE_PATH, parser, ui);
        loadSave(parser, save);
        run();
    }

    /**
     * Loads the save file.
     *
     * @param parser The Parser object
     * @param save   The Save object
     */
    public static void loadSave(Parser parser, Save save) {
        try {
            tasks = new TaskList(parser, ui, save.readFile());
        } catch (IOException | DateTimeParseException e) {
            save.createFile();
            tasks = new TaskList(parser, ui);
        }
    }

    /**
     * Exits the program.
     */
    public static void exitProgram() {
        System.out.println(Text.EXIT);
        System.exit(0);
    }

    /**
     * Main running function of the program.
     */
    public static void run() {
        boolean isRunning = true;

        while (isRunning) {
            String[] userInput = ui.readInput();
            Command c = parser.parseCommand(userInput, parser);
            c.execute(tasks, ui, save);
            isRunning = !c.isExit();
        }
        exitProgram();
    }
}
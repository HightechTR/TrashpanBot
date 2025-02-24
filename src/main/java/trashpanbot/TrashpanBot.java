package trashpanbot;

import java.io.IOException;

import trashpanbot.io.*;
import trashpanbot.task.*;
import trashpanbot.save.*;

public class TrashpanBot {
    private final Ui ui = new Ui();
    private TaskList tasks;

    public static final String filePath = "data/TaskList.txt";

    /**
     * Exits the program.dd
     */
    public void exitProgram() {
        System.out.println(Text.BYE);
        System.exit(0);
    }

    public TrashpanBot(String filePath) {
        Save save = new Save();
        ui.showIntro();

        try {
            tasks = new TaskList(save.readFile(filePath));
        } catch (IOException e) {
            save.createFile(filePath);
            tasks = new TaskList();
        }
    }

    public void run() {
        boolean isRunning = true;
        ui.displayCommands();

        while (isRunning) {
            try {
                String[] userInput = ui.readInput();
                isRunning = Parser.parseCommand(tasks, userInput);
            } catch (IOException ignored) {
                // IOException should only be thrown in save load
            }
        }
        exitProgram();
    }

    public static void main(String[] args) {
        new TrashpanBot(filePath).run();
    }
}
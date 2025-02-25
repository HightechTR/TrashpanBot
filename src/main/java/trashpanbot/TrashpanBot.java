package trashpanbot;

import java.io.IOException;

import trashpanbot.command.*;
import trashpanbot.common.*;
import trashpanbot.data.io.*;
import trashpanbot.data.task.*;
import trashpanbot.data.save.*;

public class TrashpanBot {
    private final Ui ui = new Ui();
    private TaskList tasks;
    private final Save save;

    public static final String filePath = "data/TaskList.txt";

    public TrashpanBot(String filePath) {
        save = new Save(filePath);
        ui.showIntro();

        try {
            tasks = new TaskList(save.readFile());
        } catch (IOException e) {
            save.createFile();
            tasks = new TaskList();
        }
    }

    /**
     * Exits the program.
     */
    public void exitProgram() {
        System.out.println(Text.BYE);
        System.exit(0);
    }

    public void run() {
        boolean isRunning = true;
        ui.displayCommands();

        while (isRunning) {
            try {
                String[] userInput = ui.readInput();
                Command c = Parser.parseCommand(userInput);
                c.execute(tasks, ui, save);
                isRunning = !c.isExit();
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